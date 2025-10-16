CREATE TABLE super_admin (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE organization (
    id SERIAL PRIMARY KEY,
    org_name VARCHAR(255) NOT NULL UNIQUE,
    contact_email VARCHAR(255) NOT NULL,
    schema_name VARCHAR(255) NOT NULL UNIQUE
);
