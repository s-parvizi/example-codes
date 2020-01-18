-- drop table if exists pet;
-- drop table if exists customer;
-- drop table if exists address;
--
-- create table pet(
-- id integer identity primary key,
-- name varchar(30),
-- birth_date date
-- );
--
-- create table customer(
-- id integer identity primary key,
-- name varchar(100)
-- );
--
-- create table address(
-- customer integer primary key references customer(id),
-- address_line varchar(100)
-- );

drop table if exists pet;
drop table if exists customer;
drop table if exists address;
drop table if exists movie;
drop table if exists rental;

create table pet(
id integer serial default value,
name varchar(30),
birth_date date
);

create table customer(
id integer serial default value,
name varchar(100)
);

create table address(
customer integer primary key references customer(id),
address_line varchar(100)
);

create table movie(
id integer serial default value,
title text,
description text
);

create table rental(
id serial primary key,
movie integer references movie(id),
duration text,
price integer
);

-- when using list instead of set
-- create table rental(
-- id serial primary key,
-- movie integer references movie(id),
-- movie_key integer,
-- duration text,
-- price integer
-- );

-- when using map instead of set
-- create table rental(
-- id serial primary key,
-- movie integer references movie(id),
-- movie_key text,
-- duration text,
-- price integer
-- );


