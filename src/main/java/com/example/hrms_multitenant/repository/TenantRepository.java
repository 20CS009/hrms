package com.example.hrms_multitenant.repository;



import com.example.hrms_multitenant.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    boolean existsByOrgName(String orgName);
    boolean existsByContactEmail(String email);
    boolean existsBySchemaName(String schemaName);

    @Query("SELECT t.schemaName FROM Tenant t WHERE t.orgName = ?1")
    String findSchemaNameByOrgName(String orgName);
}