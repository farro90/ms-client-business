package com.nttdata.bc19.msclientbusiness.api;

import com.nttdata.bc19.msclientbusiness.model.BusinessClient;
import com.nttdata.bc19.msclientbusiness.service.IBusinessClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client/business")
public class BusinessClientApi {
    @Autowired
    private IBusinessClientService businessClientService;

    @PostMapping
    public Mono<BusinessClient> create(@RequestBody BusinessClient businessClient){ return businessClientService.create(businessClient); }

    @PutMapping
    public Mono<BusinessClient> update(@RequestBody BusinessClient businessClient){ return businessClientService.update(businessClient); }

    @GetMapping
    public Flux<BusinessClient> findAll(){
        return businessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<BusinessClient> findById(@PathVariable String id){ return businessClientService.findById(id); }
    /*
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return businessClientService.deleteById(id);
    }
     */
}
