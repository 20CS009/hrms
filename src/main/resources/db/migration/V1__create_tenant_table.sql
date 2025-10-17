CREATE TABLE public.tenant (
    id BIGSERIAL PRIMARY KEY,
    org_name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255) NOT NULL,
    schema_name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);