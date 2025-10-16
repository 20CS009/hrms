package com.example.hrms_multitenant.service;

import com.example.hrms_multitenant.entity.SuperAdmin;
import com.example.hrms_multitenant.exception.DuplicateEmailException;
import com.example.hrms_multitenant.repository.SuperAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SuperAdminService {

    private final SuperAdminRepository superAdminRepository;

    @Transactional
    public SuperAdmin registerSuperAdmin(String email, String password) {

        // Check if email already exists
        if (superAdminRepository.existsByEmail(email)) {
            throw new DuplicateEmailException("Super admin with this email already exists");
        }

        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setEmail(email);
        superAdmin.setPassword(password); // Ideally, encode password with BCryptPasswordEncoder

        return superAdminRepository.save(superAdmin);
    }
}
