package com.pizzadelivery.pipizaria.status_pedidos;

import jakarta.validation.constraints.NotNull;

public record StatusPedidosRecordDto(@NotNull String status) {
}
