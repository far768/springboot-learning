package com.springboot.springbootlearning.service;

import com.springboot.springbootlearning.model.Tenant;

import java.util.List;
import java.util.Optional;

public interface TenantService {

    List<Tenant> findAll();

    Optional<Tenant> findById(String id);

    void createOrUpdateTenants(List<Tenant> tenants);

    void deleteAll();

    void deleteById(String id);


}
