package com.nttdata.bc19.msclientbusiness.service;

import com.nttdata.bc19.msclientbusiness.model.BusinessClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessClientService {
    Mono<BusinessClient> create(BusinessClient businessClient);
    Mono<BusinessClient> update(BusinessClient businessClient);
    Mono<Void>deleteById(String id);
    Mono<BusinessClient> findById(String id);
    Flux<BusinessClient> findAll();
}
