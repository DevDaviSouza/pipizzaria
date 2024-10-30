CREATE TABLE pedido (
    id                  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    numero_pedido       int,
    data_pedido         datetime,
    id_status           BINARY(16),
    id_cliente          BINARY(16),
    id_atendente        BINARY(16),
    FOREIGN KEY(id_cliente) REFERENCES cliente(id),
    FOREIGN KEY(id_atendente) REFERENCES atendente(id),
    FOREIGN KEY(id_status) REFERENCES status_pedidos(id)
);