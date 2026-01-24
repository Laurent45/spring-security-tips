-- 1. Insert Authorities
INSERT INTO authorities (name)
VALUES ('READ'),
       ('WRITE'),
       ('REMOVE');

-- 2. Insert Users
-- Passwords shown are dummy hashes for 'password123'
INSERT INTO users (username, password, algorithm)
VALUES ('john_doe', '$2a$10$WnrWA6v.zdyi6KPg52ad/OnHWVOJnvadnZP6hvSMp5uERlUK7bdoC', 'BCRYPT'),
       ('jane_admin', '$2a$10$WnrWA6v.zdyi6KPg52ad/OnHWVOJnvadnZP6hvSMp5uERlUK7bdoC', 'BCRYPT'),
       ('dev_user', '7d54b16004ac2cf03ffcb9996698fda8308936ce3eeacc7e004ab761ed8c23616d7e59c053f8c861b1896048162febd6', 'PBKDF2');

-- 3. Link Users to Authorities
INSERT INTO user_authorities (user_id, authority_id)
VALUES (1, 1), -- john_doe -> READ
       (2, 1), -- jane_admin -> READ
       (2, 2), -- jane_admin -> WRITE
       (3, 3); -- dev_user -> REMOVE

-- 4. Insert Products
INSERT INTO products (name, price, currency)
VALUES ('Wireless Mouse', 29.99, 'USD'),
       ('Mechanical Keyboard', 120.50, 'USD'),
       ('Gaming Monitor', 350.00, 'EUR'),
       ('USB-C Hub', 45.00, 'EUR');