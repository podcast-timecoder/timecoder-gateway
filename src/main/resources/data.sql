TRUNCATE TABLE roles;

INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_USER');

DELETE FROM users
WHERE username in ('QAGuild');

DELETE FROM user_roles
WHERE user_id IN (1);

insert into users (
    id,
    email,
    name,
    `password`,
    username)
values (
    1,
    'admin@ukr.net',
    'admin',
    '$2a$10$LxEsIfZSh.tX7N.Bthv0wuINJjMpnpVyuDXxuljHDhPejz96Ms.k.',
    'QAGuild');

insert into user_roles (role_id, user_id) values (1, 1);



