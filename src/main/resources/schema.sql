USE coffee;
DROP TABLE IF EXISTS people;
CREATE TABLE people
(
    id integer not null auto_increment,
    name char(255) not null,
    password char(128) not null,
    primary key(id)
);
ALTER table people AUTO_INCREMENT = 10000;

DROP TABLE IF EXISTS coffee;
CREATE TABLE coffee
(
    id integer not null,
    time timestamp,
    caffeine float,
    primary key(id)
);