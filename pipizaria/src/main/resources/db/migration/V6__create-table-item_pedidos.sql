CREATE TABLE item_pedidos (
    id                          BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    quantidade_itens             int,
    id_produto                  BINARY(16),
    id_pedido                   BINARY(16),
    FOREIGN KEY(id_produto) REFERENCES produto(id),
    FOREIGN KEY(id_pedido) REFERENCES pedido(id)
);