CREATE TABLE country
(
  id          INTEGER      NOT NULL,
  countryName VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

-- create users table for Spring Security
CREATE TABLE users
(
  username VARCHAR(50) NOT NULL,
  password VARCHAR(68) NOT NULL,
  enabled  TINYINT(1)  NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles
(
  user_role_id INT(11)      NOT NULL AUTO_INCREMENT,
  username     VARCHAR(50)  NOT NULL,
  role         VARCHAR(100) NOT NULL DEFAULT 'user',
  PRIMARY KEY (user_role_id),
  --UNIQUE KEY uni_username_role ( ROLE, username),
  --KEY fk_username_idx (username),
  --CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);

-- can be created by hibernate
CREATE TABLE person
(
  id         BIGINT       NOT NULL,
  name       VARCHAR(255) NOT NULL,
  location   VARCHAR(255),
  birth_date TIMESTAMP,
  PRIMARY KEY (id)
);
