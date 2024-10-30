CREATE TABLE opiniao (
    id                  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    descricao_opiniao   varchar(500),
    id_cliente          BINARY(16),
    id_pedido           BINARY(16),
    FOREIGN KEY(id_cliente) REFERENCES cliente(id),
    FOREIGN KEY(id_pedido)  REFERENCES pedido(id)
);