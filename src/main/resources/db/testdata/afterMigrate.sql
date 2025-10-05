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
VALUES (TRIM('Erro ao gerar PDF da fatura'), 3, '2025-10-01', '2025-10-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Dashboard de vendas não carrega erro 500'), 3, '2025-10-01', '2025-10-03', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Login não funciona para novo usuário'), 3, '2025-10-02', '2025-10-04', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Permissão negada ao acessar módulo de expedição'), 3, '2025-10-02', '2025-10-04', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Importação de CSV falhou com erro de formato'), 3, '2025-10-03', '2025-10-05', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Relatório mensal exporta valores incorretos'), 3, '2025-10-03', '2025-10-05', 4);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('E-mail de recuperação de senha não enviado'), 1, '2025-10-05', '2025-10-06', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Lentidão geral após atualização de versão'), 1, '2025-10-05', '2025-10-06', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Duplicidade de pedidos no fechamento do caixa'), 1, '2025-10-06', '2025-10-08', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Falha ao imprimir etiqueta de código de barras'), 1, '2025-10-06', '2025-10-08', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Cálculo de imposto ICMS divergente'), 1, '2025-10-07', '2025-10-09', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Upload de arquivo bloqueado por tamanho'), 1, '2025-10-07', '2025-10-09', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Webhook de pagamento retornando 401'), 2, '2025-10-08', '2025-10-10', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Filtro por data não aplica corretamente'), 2, '2025-10-08', '2025-10-10', 2);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Campo obrigatório não está sendo validado'), 2, '2025-10-09', '2025-10-11', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Notificações push não chegam no app'), 2, '2025-10-09', '2025-10-11', 3);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Timeout ao consultar lista de clientes'), 2, '2025-10-10', '2025-10-12', 1);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Ordenação da tabela ignora acentuação'), 2, '2025-10-10', '2025-10-12', 1);

INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Erro 404 ao acessar rota de relatório'), 3, '2025-10-12', '2025-10-14', 4);
INSERT INTO ticket (title, client_id, opening_date, closing_date, module_id)
VALUES (TRIM('Conciliação bancária não fecha saldo'), 3, '2025-10-12', '2025-10-14', 4);
