package com.example.hrms_multitenant.exception;

public class DuplicateOrgException extends RuntimeException {
    public DuplicateOrgException(String message) {
        super(message);
    }
}
