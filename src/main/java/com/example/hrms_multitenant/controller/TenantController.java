package com.example.hrms_multitenant.controller;

import com.example.hrms_multitenant.dto.TenantRegisterRequest;
import com.example.hrms_multitenant.dto.TenantRegisterResponse;
import com.example.hrms_multitenant.service.TenantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping("/register")
    public ResponseEntity<TenantRegisterResponse> registerTenant(
            @Valid @RequestBody TenantRegisterRequest request) {
        TenantRegisterResponse response = tenantService.registerTenant(request);
        return ResponseEntity.ok(response);
    }
}
