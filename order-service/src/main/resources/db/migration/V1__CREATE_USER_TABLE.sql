CREATE TABLE users (
                       id int8 NOT NULL AUTO_INCREMENT,
                       first_name varchar(255) NOT NULL,
                       last_name varchar(255) NOT NULL,
                       username varchar(255) NOT NULL,
                       CONSTRAINT users_pkey PRIMARY KEY (id),
                       CONSTRAINT uk_username UNIQUE (username)
);