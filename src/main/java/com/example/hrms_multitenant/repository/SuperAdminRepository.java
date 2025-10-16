package com.example.hrms_multitenant.repository;

import com.example.hrms_multitenant.entity.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {

    boolean existsByEmail(String email);
//    Optional<SuperAdmin> findByEmail(String email);
}