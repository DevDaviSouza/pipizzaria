package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.produto.Produto;

import java.util.UUID;

//classe record para transferência de dados e manipulação de retorno dos endpoints(metodos)
public record ItemPedidosData(UUID id, int qtdItens, Produto idProduto, Pedido idPedido) {
}
