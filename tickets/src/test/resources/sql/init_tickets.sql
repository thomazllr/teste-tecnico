INSERT INTO client (name) VALUES
    ('Thomaz Ltda'),
    ('Tech Soluções'),
    ('E-corp');

INSERT INTO module (name) VALUES
    ('Financeiro'),
    ('TI'),
    ('Suporte');

-- Inserir tickets sem a coluna 'description'
INSERT INTO ticket (title, client_id, module_id, opening_date, closing_date)
VALUES
    ('Problema ao gerar PDF', 1, 1, DATE '2025-10-01', DATE '2025-10-03'),
    ('Login não funciona', 1, 2, DATE '2025-10-02', DATE '2025-10-05'),
    ('Erro no dashboard', 1, 3, DATE '2025-10-03', DATE '2025-10-04'),
    ('Relatório incompleto', 2, 1, DATE '2025-10-05', DATE '2025-10-07'),
    ('Tela travando ao carregar', 2, 2, DATE '2025-10-06', DATE '2025-10-08'),
    ('Erro ao salvar dados', 2, 3, DATE '2025-10-07', DATE '2025-10-09'),
    ('Desempenho muito baixo', 3, 1, DATE '2025-10-08', DATE '2025-10-10'),
    ('Falha ao carregar imagens', 3, 2, DATE '2025-10-09', DATE '2025-10-12'),
    ('Erro na exportação de dados', 3, 3, DATE '2025-10-10', DATE '2025-10-13'),
    ('Atualização não é concluída', 1, 1, DATE '2025-10-11', DATE '2025-10-14');


