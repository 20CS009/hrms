package com.example.hrms_multitenant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
@Entity
@Table(name = "tenant") // stored in public schema by default
@Getter
@Setter
public class Tenant {
=======
>>>>>>> 5757ae1f76b78cbe3d2b5ef156c2d369a1c51216

@Data
@NoArgsConstructor
@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "org_name", nullable = false)
    private String orgName;

    @Column(name = "contact_email", nullable = false, unique = true)
    private String contactEmail;

    @Column(name = "schema_name", nullable = false, unique = true)
=======
    @Column(nullable = false)
    private String orgName;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false, unique = true)
>>>>>>> 5757ae1f76b78cbe3d2b5ef156c2d369a1c51216
    private String schemaName;
}
