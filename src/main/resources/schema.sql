DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS authorities CASCADE;
DROP TABLE IF EXISTS user_authorities CASCADE;
DROP TABLE IF EXISTS products CASCADE;

DROP TYPE IF EXISTS algorithm;
DROP TYPE IF EXISTS currency;

CREATE TYPE algorithm AS ENUM('BCRYPT', 'PBKDF2');
CREATE TYPE currency AS ENUM('USD', 'EUR');

CREATE TABLE users
(
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    algorithm  ALGORITHM    NOT NULL
);

CREATE TABLE authorities
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE user_authorities
(
    user_id      INT NOT NULL,
    authority_id INT NOT NULL,

    PRIMARY KEY (user_id, authority_id),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_authority
        FOREIGN KEY (authority_id) REFERENCES authorities (id) ON DELETE CASCADE
);

CREATE TABLE products
(
    id       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name     VARCHAR(50)    NOT NULL UNIQUE,
    price    NUMERIC(12, 2) NOT NULL,
    currency CURRENCY       NOT NULL
);