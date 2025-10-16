package com.example.hrms_multitenant.service;

import com.example.hrms_multitenant.entity.TenantUser;
import com.example.hrms_multitenant.exception.InvalidCredentialsException;
import com.example.hrms_multitenant.repository.TenantUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantUserService {

    private final TenantUserRepository tenantUserRepository;

    // Login by checking credentials
    public TenantUser login(String orgName, String email, String password) {
        TenantUser user = tenantUserRepository.findByOrgNameAndEmail(orgName, email)
                .orElseThrow(() -> new InvalidCredentialsException("User not found organization:" +orgName));

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid password");
        }

        return user;
    }

    // Get all users by organization
    public List<TenantUser> getAllUsers(String orgName) {
        return tenantUserRepository.findByOrgName(orgName);
    }
}
