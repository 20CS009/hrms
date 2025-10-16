package com.example.hrms_multitenant.controller;

import com.example.hrms_multitenant.dto.SuperAdminRegisterRequest;
import com.example.hrms_multitenant.dto.SuperAdminResponse;
import com.example.hrms_multitenant.service.SuperAdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/super")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/register")
    public ResponseEntity<SuperAdminResponse> register(@Valid @RequestBody SuperAdminRegisterRequest request) {
        superAdminService.registerSuperAdmin(request.getEmail(), request.getPassword());

        return ResponseEntity.ok(new SuperAdminResponse("Super admin registered successfully!"));
    }
}
