package com.example.hrms_multitenant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TenantSchemaCreator {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Creates a new schema for the tenant and initializes default tables.
     *
     * @param schemaName the schema name to create
     */
    public void createSchema(String schemaName) {
        // 1️⃣ Create schema if not exists
        String createSchemaSql = "CREATE SCHEMA IF NOT EXISTS " + schemaName;
        jdbcTemplate.execute(createSchemaSql);

        // 2️⃣ Create a sample employee table inside the new schema
        String createEmployeeTableSql = """
            CREATE TABLE IF NOT EXISTS %s.employee (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                email VARCHAR(255) UNIQUE NOT NULL,
                password VARCHAR(255) NOT NULL,
                role VARCHAR(50) NOT NULL
            )
            """.formatted(schemaName);
        jdbcTemplate.execute(createEmployeeTableSql);

        // 3️⃣ You can add more default tables here if needed
    }
}
