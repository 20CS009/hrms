package com.example.hrms_multitenant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TenantUserResponse {
    private String orgName;
    private String email;
}


