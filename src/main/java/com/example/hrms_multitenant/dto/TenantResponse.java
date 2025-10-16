package com.example.hrms_multitenant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TenantResponse {
    private Long id;
    private String orgName;
    private String contactEmail;
    private String schemaName;
    private String message;

    public TenantResponse(){ }

    public TenantResponse(String message){
        this.message=message;
    }
}
