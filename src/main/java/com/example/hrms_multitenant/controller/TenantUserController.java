package com.example.hrms_multitenant.controller;

import com.example.hrms_multitenant.dto.LoginResponse;
import com.example.hrms_multitenant.dto.TenantLoginRequest;
import com.example.hrms_multitenant.dto.TenantUserResponse;
import com.example.hrms_multitenant.entity.TenantUser;
import com.example.hrms_multitenant.exception.InvalidCredentialsException;
import com.example.hrms_multitenant.service.TenantUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tenant")
@RequiredArgsConstructor
public class TenantUserController {

    private final TenantUserService tenantUserService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody TenantLoginRequest request) {
        // The service returns the user if credentials are correct, else throws exception
        TenantUser user = tenantUserService.login(request.getOrgName(), request.getEmail(), request.getPassword());

        // Return a success response
        return ResponseEntity.ok(new LoginResponse("Login successful for user: " + user.getEmail()));
    }

    // Get all users for an organization
    @GetMapping("/users")
    public ResponseEntity<List<TenantUserResponse>> getAllUsers(@RequestParam String orgName) {
        List<TenantUserResponse> users = tenantUserService.getAllUsers(orgName)
                .stream()
                .map(u -> new TenantUserResponse(u.getOrgName(), u.getEmail()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }
}
