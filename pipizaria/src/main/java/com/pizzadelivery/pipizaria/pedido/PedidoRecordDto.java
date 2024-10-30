package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.atendente.Atendente;
import com.pizzadelivery.pipizaria.cliente.Cliente;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record PedidoRecordDto(@NotNull int numeroPedido, @NotNull LocalDateTime dataPedido, @NotNull UUID status, @NotNull UUID idCliente, @NotNull UUID idAtendente) {

}
