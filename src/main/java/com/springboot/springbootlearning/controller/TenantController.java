package com.springboot.springbootlearning.controller;

import com.springboot.springbootlearning.model.Tenant;
import com.springboot.springbootlearning.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping
    public List<Tenant> findAll() {
        return tenantService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tenant> findById(@PathVariable String id) {
        return tenantService.findById(id);
    }

    @PostMapping
    public void createOrUpdate(@RequestBody List<Tenant> tenants) {
        tenantService.createOrUpdateTenants(tenants);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        tenantService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        tenantService.deleteAll();
    }



}
