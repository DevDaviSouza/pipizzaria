package com.pizzadelivery.pipizaria.pedido;

import java.time.LocalDateTime;
import java.util.UUID;

public record PedidoData(UUID id, int numeroPedido, LocalDateTime dataPedido) {
}
