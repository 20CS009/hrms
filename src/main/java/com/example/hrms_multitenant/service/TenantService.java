package com.example.hrms_multitenant.service;

import com.example.hrms_multitenant.dto.TenantRegisterRequest;
import com.example.hrms_multitenant.dto.TenantRegisterResponse;
import com.example.hrms_multitenant.entity.Tenant;
import com.example.hrms_multitenant.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public TenantRegisterResponse registerTenant(TenantRegisterRequest request) {
        // Check if schema already exists
        if (tenantRepository.existsBySchemaName(request.getSchemaName())) {
            throw new RuntimeException("Schema name already exists");
        }

        Tenant tenant = new Tenant();
        tenant.setOrgName(request.getOrgName());
        tenant.setContactEmail(request.getContactEmail());
        tenant.setSchemaName(request.getSchemaName());

        Tenant savedTenant = tenantRepository.save(tenant);

        return new TenantRegisterResponse(
                savedTenant.getId(),
                savedTenant.getOrgName(),
                savedTenant.getContactEmail(),
                savedTenant.getSchemaName()
        );
    }
}
