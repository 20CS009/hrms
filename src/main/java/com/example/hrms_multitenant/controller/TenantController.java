package com.example.hrms_multitenant.controller;

import com.example.hrms_multitenant.dto.TenantRegisterRequest;
import com.example.hrms_multitenant.dto.TenantResponse;
import com.example.hrms_multitenant.entity.Tenant;
import com.example.hrms_multitenant.service.TenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping("/register")
    public ResponseEntity<TenantResponse> register(@Valid @RequestBody TenantRegisterRequest request) {

       Tenant tenant=tenantService.registerTenant(request.getOrgName(), request.getContactEmail());
        TenantResponse response = new TenantResponse();
        response.setId(tenant.getId());
        response.setOrgName(tenant.getOrgName());
        response.setContactEmail(tenant.getContactEmail());
        response.setSchemaName(tenant.getSchemaName());

        return ResponseEntity.ok(response);



    }
}
