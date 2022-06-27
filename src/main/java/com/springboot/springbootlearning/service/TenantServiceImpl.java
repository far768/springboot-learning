package com.springboot.springbootlearning.service;

import com.springboot.springbootlearning.model.Tenant;
import com.springboot.springbootlearning.repository.TenantMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    TenantMongoRepository tenantMongoRepository;

    @Override
    public List<Tenant> findAll() {
        return tenantMongoRepository.findAll();
    }

    @Override
    public Optional<Tenant> findById(String id) {
        return tenantMongoRepository.findById(id);
    }

    @Override
    public void createOrUpdateTenants(List<Tenant> tenants) {
        tenantMongoRepository.saveAll(tenants);
    }

    @Override
    public void deleteAll() {
        tenantMongoRepository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        tenantMongoRepository.deleteById(id);
    }
}
