package com.example.hrms_multitenant.repository;



import com.example.hrms_multitenant.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
<<<<<<< HEAD
    boolean existsBySchemaName(String schemaName);
=======
//    boolean existsByOrgName(String orgName);
//    boolean existsByContactEmail(String email);
    boolean existsBySchemaName(String schemaName);


>>>>>>> 5757ae1f76b78cbe3d2b5ef156c2d369a1c51216
}