DELETE FROM client;
DELETE FROM module;
DELETE FROM ticket;

INSERT INTO client (name) VALUES ('Apple Inc.');
INSERT INTO client (name) VALUES ('Google');
INSERT INTO client (name) VALUES ('Microsoft');
INSERT INTO client (name) VALUES ('Tesla');
INSERT INTO client (name) VALUES ('SpaceX');

INSERT INTO module (name) VALUES ('Financeiro');
INSERT INTO module (name) VALUES ('Vendas');
INSERT INTO module (name) VALUES ('Expedição');
INSERT INTO module (name) VALUES ('Foguetes');

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro '), 1, '2021-03-01', '2021-03-02', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Praesent malesuada urna nisi '), 1, '2021-03-01', '2021-03-02', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris '), 1, '2021-03-01', '2021-03-02', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie '), 1, '2021-03-01', '2021-03-02', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia '), 1, '2021-03-01', '2021-03-02', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem '), 1, '2021-03-01', '2021-03-02', 2);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado '), 1, '2021-03-01', '2021-03-02', 2);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro '), 1, '2021-03-01', '2021-03-02', 2);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Praesent malesuada urna nisi '), 1, '2021-03-01', '2021-03-02', 2);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris '), 1, '2021-03-01', '2021-03-02', 2);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie '), 1, '2021-03-01', '2021-03-02', 3);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia '), 1, '2021-03-01', '2021-03-02', 3);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem '), 1, '2021-03-01', '2021-03-02', 3);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado '), 1, '2021-03-10', '2021-03-11', 3);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro '), 1, '2021-03-10', '2021-03-11', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Praesent malesuada urna nisi '), 1, '2021-03-10', '2021-03-11', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris '), 1, '2021-03-10', '2021-03-11', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie '), 1, '2021-03-21', '2021-03-24', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia '), 1, '2021-03-21', '2021-03-24', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem '), 1, '2021-03-21', '2021-03-24', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado '), 1, '2021-03-21', '2021-03-24', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro '), 1, '2021-03-21', '2021-03-24', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 1, '2021-03-21', '2021-03-24', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 1, '2021-03-24', '2021-03-25', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 1, '2021-03-24', '2021-03-25', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 1, '2021-03-24', '2021-03-25', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 1, '2021-03-24', '2021-03-25', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 1, '2021-03-24', '2021-03-25', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Praesent malesuada urna nisi'), 1, '2021-03-24', '2021-03-25', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 1, '2021-03-24', '2021-03-25', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 1, '2021-03-24', '2021-03-25', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 1, '2021-03-30', '2021-03-31', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 2, '2021-03-01', '2021-03-03', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 2, '2021-03-01', '2021-03-03', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 2, '2021-03-01', '2021-03-03', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Praesent malesuada urna nisi'), 2, '2021-03-01', '2021-03-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 2, '2021-03-01', '2021-03-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 2, '2021-03-01', '2021-03-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 2, '2021-03-01', '2021-03-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 2, '2021-03-01', '2021-03-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 2, '2021-03-01', '2021-03-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 2, '2021-03-01', '2021-03-03', 2);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 1, '2021-04-01', '2021-04-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 1, '2021-04-02', '2021-04-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 1, '2021-04-02', '2021-04-03', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 1, '2021-04-02', '2021-04-03', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 1, '2021-04-02', '2021-04-03', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 1, '2021-04-02', '2021-04-03', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 2, '2021-05-01', '2021-05-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 2, '2021-05-02', '2021-05-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 2, '2021-05-02', '2021-05-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 2, '2021-05-02', '2021-05-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 2, '2021-05-02', '2021-05-03', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 2, '2021-05-02', '2021-05-03', 3);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 3, '2021-06-01', '2021-06-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 3, '2021-06-01', '2021-06-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 3, '2021-06-01', '2021-06-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 3, '2021-06-01', '2021-06-03', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 3, '2021-06-01', '2021-06-03', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 3, '2021-06-01', '2021-06-03', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Sapien in monti palavris'), 1, '2021-07-01', '2021-07-02', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Aenean aliquam molestie'), 1, '2021-07-01', '2021-07-02', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Interessantiss quisso pudia'), 1, '2021-07-01', '2021-07-02', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('In elementis mé pra quem'), 1, '2021-07-01', '2021-07-02', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Em pé sem cair deitado'), 1, '2021-07-01', '2021-07-02', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Mussum Ipsum cacilds vidis litro'), 1, '2021-07-01', '2021-07-02', 1);
