INSERT INTO country
VALUES (10001, 'India');

INSERT INTO country
VALUES (10002, 'China');


INSERT INTO person (id, name, location, birth_date)
VALUES (10001, 'Ranga', 'Hyderabad', sysdate());
INSERT INTO person (id, name, location, birth_date)
VALUES (10002, 'James', 'New York', sysdate());
INSERT INTO person (id, name, location, birth_date)
VALUES (10003, 'Pieter', 'Amsterdam', sysdate());


INSERT INTO users (username, password, enabled)
VALUES ('employee', '{noop}test123', true); -- test123

INSERT INTO users (username, password, enabled)
VALUES ('manager', '{noop}test123', true); -- test123

INSERT INTO users (username, password, enabled)
VALUES ('admin', '{bcrypt}$2a$12$Cz3TZJklwK27YOPDTHcjsOktEmNAB7NkJ/9C7W1m7htx/zrg/s/OC', true); -- test123


INSERT INTO user_roles  (username, role)
VALUES ('employee', 'USER');

INSERT INTO user_roles  (username, role)
VALUES ('manager', 'USER');

INSERT INTO user_roles  (username, role)
VALUES ('manager', 'MANAGER');

INSERT INTO user_roles  (username, role)
VALUES ('admin', 'USER');

INSERT INTO user_roles  (username, role)
VALUES ('admin', 'ADMIN');



