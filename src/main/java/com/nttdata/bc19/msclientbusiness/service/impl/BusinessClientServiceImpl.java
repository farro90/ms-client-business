package com.nttdata.bc19.msclientbusiness.service.impl;

import com.nttdata.bc19.msclientbusiness.exception.ModelNotFoundException;
import com.nttdata.bc19.msclientbusiness.model.BusinessClient;
import com.nttdata.bc19.msclientbusiness.repository.IBusinessClientRepository;
import com.nttdata.bc19.msclientbusiness.service.IBusinessClientService;
import com.nttdata.bc19.msclientbusiness.util.LogMessage;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Service
public class BusinessClientServiceImpl implements IBusinessClientService {

    private final Logger LOGGER = LoggerFactory.getLogger("BusinessClientLog");
    private final String SAVESUCCESS = "SAVESUCCESS";
    private final String UPDATESUCCESS = "UPDATESUCCESS";
    private final String DELETESUCCESS = "DELETESUCCESS";
    @Autowired
    IBusinessClientRepository iBusinessClientRepository;

    @Override
    public Mono<BusinessClient> create(BusinessClient businessClient) {

        businessClient.setId(new ObjectId().toString());
        businessClient.setCreatedAt(LocalDateTime.now());
        return iBusinessClientRepository.save(businessClient).doOnSuccess(this.doOnSucess(SAVESUCCESS));
    }

    @Override
    public Mono<BusinessClient> update(BusinessClient businessClient) {
        businessClient.setUpdatedAt(LocalDateTime.now());
        return iBusinessClientRepository
                .findById(businessClient.getId())
                .switchIfEmpty(Mono.error(new ModelNotFoundException(LogMessage.idNotFound)))
                .flatMap(businessClientFind -> {
                    return iBusinessClientRepository.save(businessClient).doOnSuccess(this.doOnSucess(UPDATESUCCESS));
                });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iBusinessClientRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new ModelNotFoundException(LogMessage.idNotFound)))
                .flatMap(personClient -> {
                    return iBusinessClientRepository.deleteById(id).doOnSuccess(this.doOnSucessDelete(DELETESUCCESS));
                });
    }

    @Override
    public Mono<BusinessClient> findById(String id) { return iBusinessClientRepository.findById(id).switchIfEmpty(Mono.error(new ModelNotFoundException(LogMessage.idNotFound))); }

    @Override
    public Flux<BusinessClient> findAll() {
        return iBusinessClientRepository.findAll();
    }

    private Consumer<BusinessClient> doOnSucess(String idLogMessage){
        return new Consumer<BusinessClient>() {
            @Override
            public void accept(BusinessClient personClient) {
                LOGGER.info(LogMessage.logMessage.get(idLogMessage));
            }
        };
    }

    private Consumer<Void> doOnSucessDelete(String idLogMessage){
        return new Consumer<Void>() {
            @Override
            public void accept(Void unused) {
                LOGGER.info(LogMessage.logMessage.get(idLogMessage));
            }
        };
    }
}
