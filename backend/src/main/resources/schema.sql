create table country
(
   id integer not null,
   countryName varchar(255) not null,
   primary key(id)
);


-- can be created by hibernate
create table person
(
   id BIGINT not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);
