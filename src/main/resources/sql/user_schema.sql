CREATE TABLE user (
    id       INTEGER      NOT NULL AUTO_INCREMENT,
    username VARCHAR(30)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
