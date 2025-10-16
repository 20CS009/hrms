package com.example.hrms_multitenant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuperAdminResponse {
    private String message;

    public SuperAdminResponse(String message) {
        this.message = message;
    }
}
