USE coffee;
CREATE TABLE IF NOT EXISTS people
(
    id integer not null auto_increment,
    name char(255) not null,
    password char(128) not null,
    email char(128) not null,
    primary key(id)
);
ALTER table people AUTO_INCREMENT = 10000;

CREATE TABLE IF NOT EXISTS coffee
(
    id integer not null,
    time timestamp,
    caffeine float,
    primary key(id)
);