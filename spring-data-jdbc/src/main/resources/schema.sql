create table pet(
id integer identity primary key,
name varchar(30),
birth_date date
);

create customer(
id integer identity primary key,
name varchar(100)
);

create table address(
id integer identity primary key,
address_line varchar(100),
customer integer
);