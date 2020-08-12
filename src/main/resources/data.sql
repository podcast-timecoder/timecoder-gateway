TRUNCATE TABLE roles;

INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');
INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');

DELETE FROM user_roles
WHERE user_id IN (1);

-- admin/123456
insert IGNORE into users (
    id,
    email,
    name,
    `password`,
    username)
values (
    1,
    'admin@ukr.net',
    'admin',
    '$2a$10$/Qnbh3.X7WQ3r1MapQH1GOq2admLt.LhcgWTZ9Hh/xG9Pq6CHDpe2',
    'admin');

insert into user_roles (role_id, user_id) values (1, 1);



