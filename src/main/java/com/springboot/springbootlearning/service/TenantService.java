package com.springboot.springbootlearning.service;

import com.springboot.springbootlearning.model.Tenant;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TenantService {

    List<Tenant> findAll();

    Optional<Tenant> findById(String id);

    List<Tenant> findByName(String name);

    void createOrUpdateTenants(List<Tenant> tenants);

    void deleteAll();

    void deleteById(String id);

    List<Tenant> getAllTenantPaginated(
            int pageNumber, int pageSize);

    List<Tenant> findByCreateOnAfter(Date date);

    List<Tenant> findByModifiedOn(Date date);

    void updateApplicationName(List<Integer> tenantId, String applicationName);


}
