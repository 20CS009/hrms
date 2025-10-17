package com.example.hrms_multitenant.repository;

import com.example.hrms_multitenant.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
