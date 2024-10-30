CREATE TABLE cliente (
    id                  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    nome_cliente        varchar(255),
    login_cliente       varchar(255),
    senha_cliente       varchar(255),
    email_cliente       varchar(255),
    cep_cliente         varchar(255),
    rua_cliente         varchar(255),
    bairro_cliente      varchar(255),
    cidade_cliente      varchar(255),
    UF_cliente          varchar(255),
    telefone_cliente    varchar(255)
);