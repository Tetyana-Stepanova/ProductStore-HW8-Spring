--liquibase formatted sql
--changeset Stepanova:init-sql-1.0.0
create table manufacturer (
    uuid VARCHAR(255) NOT NULL DEFAULT(uuid()) PRIMARY KEY,
    manuf_name VARCHAR(255)
);
create table product (
    uuid VARCHAR(255) NOT NULL DEFAULT(uuid()) PRIMARY KEY ,
    product_name VARCHAR(255),
    price DECIMAL,
    manuf_uuid VARCHAR(255),
    FOREIGN KEY (manuf_uuid) REFERENCES manufacturer(uuid) ON DELETE SET NULL
);

create table role
(
    uuid      VARCHAR(255) NOT NULL DEFAULT(uuid()) PRIMARY KEY ,
    role_name VARCHAR(255)
);
create table user
(
    uuid       VARCHAR(255) NOT NULL DEFAULT(uuid()) PRIMARY KEY ,
    email      VARCHAR(255),
    password   VARCHAR(255),
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

create table user_role
(
    uuid_role VARCHAR(255),
    uuid_user VARCHAR(255),
    UNIQUE (uuid_role, uuid_user),
    FOREIGN KEY (uuid_role) REFERENCES role (uuid) ON DELETE CASCADE,
    FOREIGN KEY (uuid_user) REFERENCES user (uuid) ON DELETE CASCADE
);



