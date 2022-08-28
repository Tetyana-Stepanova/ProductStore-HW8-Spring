--liquibase formatted sql
--changeset Stepanova:populate-sql-1.0.0

INSERT INTO manufacturer(uuid ,manuf_name)
VALUES ('e1ff94c6-2460-11ed-8b4e-3c7c3f5a3a38', 'Easy Step Dnepr'),
       ('e1ff9b0b-2460-11ed-8b4e-3c7c3f5a3a38', 'GEM'),
       ('e1ff9c91-2460-11ed-8b4e-3c7c3f5a3a38', 'MIDA'),
       ('e1ff9d08-2460-11ed-8b4e-3c7c3f5a3a38', 'Bandinelly');

INSERT INTO product(product_name, price, manuf_uuid)
VALUES ('Sneakers', 1700, 'e1ff9c91-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Converse', 2300, 'e1ff9d08-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Sandal', 1400, 'e1ff9b0b-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Trainer', 1600, 'e1ff9d08-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Loafer', 1800, 'e1ff94c6-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Oxford', 2100, 'e1ff9d08-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Moccasin', 1900, 'e1ff9b0b-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('High-Hop Sneaker', 2400, 'e1ff94c6-2460-11ed-8b4e-3c7c3f5a3a38'),
       ('Hiking boot', 2200, 'e1ff9c91-2460-11ed-8b4e-3c7c3f5a3a38');

INSERT INTO role(uuid, role_name)
VALUES ('3a4a59bd-f0c2-4802-afe5-59d906d20a29', 'ROLE_USER'),
       ('2250d955-ed40-4944-9f17-f6916d8a9d1e', 'ROLE_ADMIN');

INSERT INTO user(uuid, email, password, first_name, last_name)
VALUES ('4ff52e7d-246e-11ed-8b4e-3c7c3f5a3a38',
        'user@gmail.com',
        '$2a$12$ne2QHqrScuNkJP8TfYtkTuzmNLSInEE.0ao1k2ZwP/1LjbiZ9zBs2',
        'user',
        'userLastName'),
       ('4ff5348d-246e-11ed-8b4e-3c7c3f5a3a38',
        'admin@gmail.com',
        '$2a$12$Ow0AsuuLe8SPlGGN04vtCO9UGHDLbL5G0p44BTNcNBUWZYXSISv3O',
        'admin',
        'adminLastName');

INSERT INTO user_role(uuid_role, uuid_user)
VALUES ('2250d955-ed40-4944-9f17-f6916d8a9d1e', '4ff5348d-246e-11ed-8b4e-3c7c3f5a3a38'),
       ('3a4a59bd-f0c2-4802-afe5-59d906d20a29', '4ff52e7d-246e-11ed-8b4e-3c7c3f5a3a38');

