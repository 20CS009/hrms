package com.example.hrms_multitenant.service;

import com.example.hrms_multitenant.entity.Tenant;
import com.example.hrms_multitenant.exception.DuplicateOrgException;
import com.example.hrms_multitenant.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    @Transactional
    public Tenant registerTenant(String orgName, String contactEmail) {

        // Check if organization already exists
        if (tenantRepository.existsByOrgName(orgName)) {
            throw new DuplicateOrgException("Organization with this name already exists");
        }

        Tenant tenant = new Tenant();
        tenant.setOrgName(orgName);
        tenant.setContactEmail(contactEmail);
        tenant.setSchemaName("tenant_" + orgName.toLowerCase().replaceAll("\\s+", "_")); // Example: create schema name

        // Save tenant
        Tenant savedTenant = tenantRepository.save(tenant);

        // Here, you can call method to create tenant schema via Flyway or JDBC
        // createTenantSchema(savedTenant.getSchemaName());

        return savedTenant;
    }
}
