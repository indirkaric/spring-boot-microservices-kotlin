CREATE TABLE countries (
                       id int8 NOT NULL AUTO_INCREMENT,
                       name varchar(255) NOT NULL,
                       CONSTRAINT countries_pkey PRIMARY KEY (id),
                       CONSTRAINT uk_country_name UNIQUE (name)
);

CREATE TABLE cities (
                           id int8 NOT NULL AUTO_INCREMENT,
                           name varchar(255) NOT NULL,
                           country_id int8 NOT NULL,
                           CONSTRAINT cities_pkey PRIMARY KEY (id),
                           CONSTRAINT uk_city_name UNIQUE (name),
                           FOREIGN KEY (country_id) REFERENCES countries(id)
);

INSERT INTO countries (name) VALUES('Bosnia and Herzegovina');
INSERT INTO countries (name) VALUES('Norway');
INSERT INTO countries (name) VALUES('Germany');
INSERT INTO countries (name) VALUES('Serbia');
INSERT INTO countries (name) VALUES('Croatia');

INSERT INTO cities(name, country_id) VALUES('Sarajevo', (Select id from countries where name = 'Bosnia and Herzegovina'));
INSERT INTO cities(name, country_id) VALUES('Oslo', (Select id from countries where name = 'Norway'));
INSERT INTO cities(name, country_id) VALUES('Berlin', (Select id from countries where name = 'Germany'));
INSERT INTO cities(name, country_id) VALUES('Belgrade', (Select id from countries where name = 'Serbia'));
INSERT INTO cities(name, country_id) VALUES('Zagreb', (Select id from countries where name = 'Croatia'));



