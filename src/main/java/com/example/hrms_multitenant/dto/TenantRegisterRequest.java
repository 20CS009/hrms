package com.example.hrms_multitenant.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantRegisterRequest {

    @NotBlank(message = "Organization name is required")
    private String orgName;

    @Email(message = "Contact email should be valid")
    @NotBlank(message = "Contact email is required")
    private String contactEmail;

    @NotBlank(message = "Schema name is required")
    private String schemaName;
}
