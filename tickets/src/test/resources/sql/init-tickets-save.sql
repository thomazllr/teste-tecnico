DELETE FROM ticket;
DELETE FROM module;
DELETE FROM client;

ALTER TABLE client ALTER COLUMN id RESTART WITH 1;
ALTER TABLE module ALTER COLUMN id RESTART WITH 1;
ALTER TABLE ticket ALTER COLUMN id RESTART WITH 1;

INSERT INTO client (name) VALUES
    ('Thomaz Ltda'),
    ('Tech Soluções'),
    ('E-corp');

INSERT INTO module (name) VALUES
    ('Financeiro'),
    ('TI'),
    ('Suporte');