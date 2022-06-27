package com.springboot.springbootlearning.repository;

import com.springboot.springbootlearning.model.Tenant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantMongoRepository extends MongoRepository<Tenant, String> {
}
