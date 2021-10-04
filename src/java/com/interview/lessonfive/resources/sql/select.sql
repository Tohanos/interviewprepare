DROP VIEW IF EXISTS cinema.films_seances;
CREATE VIEW cinema.films_seances AS
SELECT title, start_time, duration
FROM cinema.films,
     cinema.seances
WHERE cinema.films.film_id = cinema.seances.film_id
ORDER BY start_time;

DROP VIEW IF EXISTS cinema.seances_tickets;
CREATE VIEW cinema.seances_tickets AS
SELECT ticket_id, seances.film_id, price, start_time
FROM cinema.seances,
     cinema.tickets
WHERE seances.seance_id = tickets.seance_id;

DROP VIEW IF EXISTS cinema.seances_total;
CREATE VIEW cinema.seances_total AS
SELECT seances.seance_id,
       seances.film_id,
       COUNT(seances.seance_id) AS seances_count,
       SUM(seances.price) AS sum_price
FROM cinema.seances,
     cinema.tickets
WHERE seances.seance_id = tickets.seance_id
group by seances.seance_id;

DROP VIEW IF EXISTS cinema.films_total;
CREATE VIEW cinema.films_total AS
SELECT ticket_id, films.film_id, title, duration, price, start_time
FROM cinema.films, cinema.seances_tickets
WHERE films.film_id = seances_tickets.film_id;

DROP VIEW IF EXISTS cinema.schedule;
CREATE VIEW cinema.schedule AS
SELECT title,
       start_time,
       duration,
       LEAD(title) OVER (ORDER BY start_time)      next_title,
       LEAD(start_time) OVER (ORDER BY start_time) next_start_time,
       LEAD(duration) OVER (ORDER BY start_time)   next_duration
FROM cinema.films_seances;

-- ошибки в расписании
SELECT * FROM cinema.schedule
WHERE next_start_time < (start_time + duration);

-- перерывы между сеансами
SELECT title,
       start_time,
       duration,
       next_start_time,
       (next_start_time - start_time - duration) break
FROM cinema.schedule
WHERE (next_start_time - start_time - duration) > '00:30:00'
ORDER BY (next_start_time - start_time - duration) DESC;

-- итоговая таблица
(SELECT films.title,
       AVG(seances_total.seances_count) AS avg_viewers,
       SUM(seances_total.seances_count) AS sum_viewers,
       SUM(seances_total.sum_price) AS sum_price
FROM cinema.films, cinema.seances_total
WHERE films.film_id = seances_total.film_id
GROUP BY films.title ORDER BY sum_price DESC)
UNION ALL
SELECT 'Total',null,null, SUM(seances_total.sum_price) FROM cinema.seances_total;

--
SELECT COUNT(ticket_id) AS viewers, SUM(price) AS sum_total
FROM cinema.films_total
WHERE start_time BETWEEN '2021-09-20 09:00:00' AND '2021-09-20 14:59:00'
UNION ALL
SELECT COUNT(ticket_id) AS viewers, SUM(price) AS sum_total
FROM cinema.films_total
WHERE start_time BETWEEN '2021-09-20 15:00:00' AND '2021-09-20 17:59:00'
UNION ALL
SELECT COUNT(ticket_id) AS viewers, SUM(price) AS sum_total
FROM cinema.films_total
WHERE start_time BETWEEN '2021-09-20 18:00:00' AND '2021-09-20 20:59:00'
UNION ALL
SELECT COUNT(ticket_id) AS viewers, SUM(price) AS sum_total
FROM cinema.films_total
WHERE start_time BETWEEN '2021-09-20 21:00:00' AND '2021-09-21 00:00:00';
