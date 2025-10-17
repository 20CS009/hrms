package com.example.hrms_multitenant.service;

import com.example.hrms_multitenant.dto.TenantRegisterRequest;
import com.example.hrms_multitenant.dto.TenantRegisterResponse;
import com.example.hrms_multitenant.entity.Employee;
import com.example.hrms_multitenant.entity.Tenant;
import com.example.hrms_multitenant.repository.EmployeeRepository;
import com.example.hrms_multitenant.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;
    private final EmployeeRepository employeeRepository;
    private final TenantSchemaCreator schemaCreator; // Utility to handle schema creation
    private final PasswordEncoder passwordEncoder; // Inject password encoder

    @Transactional
    public TenantRegisterResponse registerTenant(TenantRegisterRequest request) {

        //  Check if schema already exists
        if (tenantRepository.existsBySchemaName(request.getSchemaName())) {
            throw new RuntimeException("Schema name already exists");
        }

        //  Save tenant info in public schema
        Tenant tenant = new Tenant();
        tenant.setOrgName(request.getOrgName());
        tenant.setContactEmail(request.getContactEmail());
        tenant.setSchemaName(request.getSchemaName());
        Tenant savedTenant = tenantRepository.save(tenant);

        // Create schema for tenant using utility
        schemaCreator.createSchema(request.getSchemaName());

        // Insert Super Admin employee in public schema-here just
        // details default whatever I add employee and role as just SuperAdmin
        Employee superAdmin = new Employee();
        superAdmin.setName("Super Admin");
        superAdmin.setEmail(request.getContactEmail());
        superAdmin.setRole("SUPER_ADMIN");
        superAdmin.setTenant(savedTenant); // Link to tenant

        // Generate and encode a default password
        String defaultPassword = "Admin@123"; // You can choose any default
        superAdmin.setPassword(passwordEncoder.encode(defaultPassword));

        employeeRepository.save(superAdmin);

        // Return DTO response
        return new TenantRegisterResponse(
                savedTenant.getId(),
                savedTenant.getOrgName(),
                savedTenant.getContactEmail(),
                savedTenant.getSchemaName()
        );
    }
}
