package com.nttdata.bc19.msclientbusiness.repository;

import com.nttdata.bc19.msclientbusiness.model.BusinessClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessClientRepository extends ReactiveMongoRepository<BusinessClient, String> {
}
