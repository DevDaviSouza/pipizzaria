package com.pizzadelivery.pipizaria.status_pedidos;

import jakarta.validation.constraints.NotNull;

//classe record para transferência de dados
public record StatusPedidosRecordDto(@NotNull String status) {
}
