-- Create a new schema
CREATE SCHEMA petdb_schema AUTHORIZATION user1;

-- Grant usage on the schema to the user
GRANT USAGE ON SCHEMA petdb_schema TO user1;

-- Grant all privileges on the schema to the user
GRANT ALL PRIVILEGES ON SCHEMA petdb_schema TO user1;

-- Grant all privileges on all tables in the schema to the user
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA petdb_schema TO user1;

-- Grant all privileges on all sequences in the schema to the user
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA petdb_schema TO user1;

-- Optionally, you can set the search path to the new schema
ALTER ROLE user1 SET search_path TO petdb_schema, public;
