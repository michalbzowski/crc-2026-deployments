-- Create deployments table
CREATE TABLE IF NOT EXISTS deployments (
    id SERIAL PRIMARY KEY,
    hostname VARCHAR(255) NOT NULL,
    version VARCHAR(255) NOT NULL,
    deployment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index on hostname for faster queries
CREATE INDEX IF NOT EXISTS idx_deployments_hostname ON deployments(hostname);

-- Add a comment to the table
COMMENT ON TABLE deployments IS 'Table storing deployment information for each application instance';
COMMENT ON COLUMN deployments.hostname IS 'The hostname of the machine running the application';
COMMENT ON COLUMN deployments.version IS 'The version/timestamp of the deployment';
COMMENT ON COLUMN deployments.deployment_time IS 'The timestamp when this deployment was recorded';
COMMENT ON COLUMN deployments.created_at IS 'The timestamp when this record was created';

