package com.pizzadelivery.pipizaria.item_pedidos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ItemPedidosRecordDto(@NotNull int qtdItens, @NotNull UUID idProduto, @NotNull UUID idPedido) {
}
