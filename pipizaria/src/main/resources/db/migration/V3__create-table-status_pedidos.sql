CREATE TABLE status_pedidos (
    id                  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    status              varchar(255)
)