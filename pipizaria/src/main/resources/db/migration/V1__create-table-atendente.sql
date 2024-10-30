CREATE TABLE atendente (
    id                  BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) PRIMARY KEY,
    nome_atendente      varchar(255),
    login_atendente     varchar(255),
    senha_atendente     varchar(255),
    email_atendente     varchar(255)
);