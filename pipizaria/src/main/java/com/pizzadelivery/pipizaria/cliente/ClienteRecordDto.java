package com.pizzadelivery.pipizaria.cliente;

import jakarta.validation.constraints.NotNull;

public record ClienteRecordDto(@NotNull String nomeCliente, @NotNull String loginCliente, @NotNull String senhaCliente, @NotNull String emailCliente, @NotNull String cepCliente, @NotNull String ruaCliente, @NotNull String bairroCliente, @NotNull String cidadeCliente, @NotNull String ufCliente, @NotNull String telefoneCliente) {
}
