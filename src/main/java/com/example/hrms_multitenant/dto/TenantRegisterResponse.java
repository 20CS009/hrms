package com.example.hrms_multitenant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class TenantRegisterResponse {
    private Long id;
    private String orgName;
    private String contactEmail;
    private String schemaName;


}
