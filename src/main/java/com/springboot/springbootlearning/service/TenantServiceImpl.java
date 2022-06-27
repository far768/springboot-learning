package com.springboot.springbootlearning.service;

import com.springboot.springbootlearning.model.Tenant;
import com.springboot.springbootlearning.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {
    private final MongoTemplate mongoTemplate;
    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    public TenantServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Tenant> findAll() {
        return tenantRepository.findAll();
    }

    @Override
    public Optional<Tenant> findById(String id) {
        return tenantRepository.findById(id);
    }

    @Override
    public List<Tenant> findByName(String name) {
        return tenantRepository.findByName(name);
    }

    @Override
    public void createOrUpdateTenants(List<Tenant> tenants) {
        for (Tenant tenant : tenants) {
            tenant.setModifiedOn(new Date());
        }
        tenantRepository.saveAll(tenants);
    }

    @Override
    public void deleteAll() {
        tenantRepository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        tenantRepository.deleteById(id);
    }

    @Override
    public List<Tenant> getAllTenantPaginated(int pageNumber, int pageSize) {
        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        return mongoTemplate.find(query, Tenant.class);
    }

    @Override
    public List<Tenant> findByCreateOnAfter(Date date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("createdOn").gte(date));
        return mongoTemplate.find(query, Tenant.class);
    }

    @Override
    public List<Tenant> findByModifiedOn(Date date) {
        Query query = new Query();
        query.addCriteria(Criteria.where("modifiedOn").is(date));
        return mongoTemplate.find(query, Tenant.class);
    }

    @Override
    public void updateApplicationName(List<Integer> tenantId, String applicationName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("tenantId").in(tenantId));
        mongoTemplate.updateMulti(query, new Update().set(applicationName, applicationName), Tenant.class);
    }

}
