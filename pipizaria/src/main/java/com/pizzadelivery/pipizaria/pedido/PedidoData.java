package com.pizzadelivery.pipizaria.pedido;

import java.time.LocalDateTime;
import java.util.UUID;

//classe record para transferência de dados e manipulação de retorno dos endpoints(metodos)
public record PedidoData(UUID id, int numeroPedido, LocalDateTime dataPedido) {
}
