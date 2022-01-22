CREATE TABLE customers (
                        id int8 NOT NULL AUTO_INCREMENT,
                        user_id int8 NOT NULL,
                        city_id int8 NOT NULL,
                        CONSTRAINT customers_pkey PRIMARY KEY (id),
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (city_id) REFERENCES cities(id)

);