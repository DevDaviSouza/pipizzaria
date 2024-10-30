package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.produto.Produto;

import java.util.UUID;

public record ItemPedidosData(UUID id, int qtdItens, Produto idProduto, Pedido idPedido) {
}
