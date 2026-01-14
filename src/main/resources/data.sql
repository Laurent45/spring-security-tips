-- Seed Users
INSERT INTO users (username, password, enabled)
VALUES
    ('admin', 'admin_secret', true),
    ('alice', 'alice_pass', true);

-- Seed Authorities
INSERT INTO authorities (username, authority)
VALUES
    ('admin', 'read'),
    ('admin', 'write'),
    ('alice', 'read');