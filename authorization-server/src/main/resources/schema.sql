CREATE TABLE IF NOT EXISTS users
(
    id            UUID DEFAULT gen_random_uuid(),
    username      VARCHAR(50) NOT NULL UNIQUE,
    password_hash TEXT        NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS otps
(
    id      UUID DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    code    VARCHAR(50) NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
