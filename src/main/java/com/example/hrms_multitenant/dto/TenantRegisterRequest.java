package com.example.hrms_multitenant.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenantRegisterRequest {

    @NotBlank(message = "Organization name is required")
    private String orgName;

    @Email(message = "Contact email should be valid")
    @NotBlank(message = "Contact email is required")
    private String contactEmail;
}
