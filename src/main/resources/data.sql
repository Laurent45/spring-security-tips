-- Seed Users
INSERT INTO users (username, password, enabled)
VALUES
    ('admin', '{text}admin_secret', true),
    ('alice', '{text}alice_pass', true);

-- Seed Authorities
INSERT INTO authorities (username, authority)
VALUES
    ('admin', 'read'),
    ('admin', 'write'),
    ('alice', 'read');