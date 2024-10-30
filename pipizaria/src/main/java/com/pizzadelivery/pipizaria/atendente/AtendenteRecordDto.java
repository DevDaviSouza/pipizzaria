package com.pizzadelivery.pipizaria.atendente;

import jakarta.validation.constraints.NotNull;

public record AtendenteRecordDto(@NotNull String nomeAtendente, @NotNull String loginAtendente, @NotNull String senhaAtendente, @NotNull String emailAtendente) {}
