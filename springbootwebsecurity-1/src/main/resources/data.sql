INSERT INTO users(username, password, enabled)
VALUES ('rakesh', 'rakesh', true);

INSERT INTO users(username, password, enabled)
VALUES ('admin', 'admin', true);

INSERT INTO authorities(username, authority)
VALUES ('rakesh', 'ROLE_USER');

INSERT INTO authorities(username, authority)
VALUES ('admin', 'ROLE_ADMIN');