CREATE TABLE products (
                       id int8 NOT NULL AUTO_INCREMENT,
                       name varchar(255) NOT NULL,
                       quantity INT NOT NULL,
                       last_updated timestamp NOT NULL,
                       CONSTRAINT products_pkey PRIMARY KEY (id),
                       CONSTRAINT uk_name UNIQUE (name)
);

INSERT INTO products (name, quantity, last_updated) VALUES('LITE RACER ADAPT 3.0 SHOES', 10, CURRENT_TIMESTAMP);
INSERT INTO products (name, quantity, last_updated) VALUES('QUESTAR FLOW NXT SHOES', 10, CURRENT_TIMESTAMP);
