DROP TABLE IF EXISTS cinema.films CASCADE;
CREATE TABLE cinema.films
(
    film_id serial PRIMARY KEY,
    title varchar(255),
    duration time
);

DROP TABLE IF EXISTS cinema.seances CASCADE;
CREATE TABLE cinema.seances
(
    seance_id serial PRIMARY KEY,
    film_id integer NOT NULL,
    start_time timestamp,
    price numeric(10, 1)
);

ALTER TABLE cinema.seances
    ADD CONSTRAINT seances_films_fk
        FOREIGN KEY (film_id) REFERENCES cinema.films (film_id);

DROP TABLE IF EXISTS cinema.tickets CASCADE;
CREATE TABLE cinema.tickets
(
    ticket_id serial PRIMARY KEY,
    seance_id integer
);

ALTER TABLE cinema.tickets
    ADD CONSTRAINT tickets_seances_fk
        FOREIGN KEY (seance_id) REFERENCES cinema.seances (seance_id);

