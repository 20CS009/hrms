package com.example.hrms_multitenant.repository;

import com.example.hrms_multitenant.dto.TenantUserResponse;
import com.example.hrms_multitenant.entity.TenantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TenantUserRepository extends JpaRepository<TenantUser, Long> {
     Optional<TenantUser> findByOrgNameAndEmail(String orgName, String email);
    List<TenantUser> findByOrgName(String orgName);

//    List<TenantUserResponse> findByOrgName(String orgName);
}
