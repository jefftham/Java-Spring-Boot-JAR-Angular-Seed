create table country
(
   id integer not null,
   countryName varchar(255) not null,
   primary key(id)
);

-- create users table for Spring Security
create table users
(
  username VARCHAR2(50) NOT NULL,
  password VARCHAR2(68) NOT NULL,
  enabled TINYINT(1) DEFAULT 1,
  CONSTRAINT  user_pk primary key(username)
);

create table authorities
(
  username VARCHAR2(50) NOT NULL,
  authority VARCHAR2(100) NOT NULL DEFAULT 'user',
  CONSTRAINT  aut_pk primary key(username),
  CONSTRAINT  user_fk FOREIGN KEY (username) REFERENCES  users(username)
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
