DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled  BOOLEAN      NOT NULL DEFAULT true
);

CREATE TABLE authorities
(
    id        INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,

    CONSTRAINT fk_authorities_users
        FOREIGN KEY (username)
            REFERENCES users (username)
            ON DELETE CASCADE
);