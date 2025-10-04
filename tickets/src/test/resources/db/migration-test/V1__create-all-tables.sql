CREATE TABLE client
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name          VARCHAR(150) NOT NULL
);

CREATE TABLE module
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name           VARCHAR(150) NOT NULL
);

CREATE TABLE ticket
(
    id             BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    client_id      BIGINT NOT NULL,
    module_id      BIGINT NOT NULL,
    opening_date   DATE NOT NULL,
    closing_date   DATE,
    CONSTRAINT fk_ticket_client FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT fk_ticket_module FOREIGN KEY (module_id) REFERENCES module(id)
);