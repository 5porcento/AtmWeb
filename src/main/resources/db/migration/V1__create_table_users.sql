CREATE TABLE users
(
    id       BIGINT NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    balance  DECIMAL NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);