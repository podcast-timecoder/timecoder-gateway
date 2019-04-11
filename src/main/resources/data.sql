TRUNCATE TABLE user_roles CASCADE;

DELETE FROM users
WHERE username in ('default_demo', 'QAGuild');

DELETE FROM user_roles
WHERE user_id IN (1,2);

insert into users (
    id,
    email,
    name,
    password,
    username)
values (
    1,
    'default_demo@gmail.com',
    'default_demo',
    '$2a$10$ADqMYwaWMYcNaSwCXq3s/OiSDVFIxrzFSSGckZpaon/OZC8eXIblG',
    'default_demo');

insert into users (
    id,
    email,
    name,
    password,
    username)
values (
    2,
    'admin@ukr.net',
    'admin',
    '$2a$10$LxEsIfZSh.tX7N.Bthv0wuINJjMpnpVyuDXxuljHDhPejz96Ms.k.',
    'QAGuild');

insert into user_roles (role_id, user_id) values (1, 1);
insert into user_roles (role_id, user_id) values (2, 2);



