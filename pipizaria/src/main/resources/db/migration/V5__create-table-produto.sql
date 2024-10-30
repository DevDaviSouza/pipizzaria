CREATE TABLE produto (
    id                  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    descricao_produto   varchar(255),
    valor_produto       double(10, 2)
);