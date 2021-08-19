CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS user
(
    id         int NOT NULL AUTO_INCREMENT,
    name       varchar(100),
    email       varchar(100),
    created_at datetime,
    updated_at datetime
);

call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at)
values (1, 'martin', 'martin@fastcampus.com', now(), now());

call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at)
values (2, 'dennis', 'dennis@fastcampus.com', now(), now());

call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at)
values (3, 'sophia', 'sophia@slowcampus.com', now(), now());

call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at)
values (4, 'james', 'james@slowcampus.com', now(), now());

call next value for hibernate_sequence;
insert into user (id, name, email, created_at, updated_at)
values (5, 'martin', 'martin@another.com', now(), now());