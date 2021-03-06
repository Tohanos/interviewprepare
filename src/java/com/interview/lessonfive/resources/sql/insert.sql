INSERT INTO cinema.films (title, duration) VALUES
('Titanic', '1:00'), ('Avatar', '2:00'), ('Terminator', '1:30'), ('Alien', '1:30'), ('Groundhog day', '1:00');

INSERT INTO cinema.seances (film_id, start_time, price) VALUES
(1, '2021-09-20 10:00:00', 300.0),
(2, '2021-09-20 11:00:00', 400),
(2, '2021-09-20 18:00:00', 400),
(3, '2021-09-20 12:30:00', 350),
(3, '2021-09-20 20:00:00', 500),
(4, '2021-09-20 13:30:00', 400),
(4, '2021-09-20 17:00:00', 450),
(5, '2021-09-20 09:00:00', 250),
(5, '2021-09-20 15:30:00', 300);

INSERT INTO cinema.tickets (seance_id) VALUES
(2), (3), (3), (1), (1), (3), (4), (1), (5), (7), (3), (1), (6);