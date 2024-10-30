package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.pedido.Pedido;
import jakarta.validation.constraints.NotNull;

//classe record para transferência de dados
public record OpiniaoRecordDto(@NotNull String descricaoOpiniao, @NotNull Cliente idCliente, @NotNull Pedido idPedido) {
}
