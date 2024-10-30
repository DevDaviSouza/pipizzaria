package com.pizzadelivery.pipizaria.atendente;

import jakarta.validation.constraints.NotNull;

// classe record para transferência de dados
public record AtendenteRecordDto(@NotNull String nomeAtendente, @NotNull String loginAtendente, @NotNull String senhaAtendente, @NotNull String emailAtendente) {}
