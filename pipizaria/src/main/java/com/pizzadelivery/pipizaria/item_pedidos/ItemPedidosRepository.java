package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemPedidosRepository extends JpaRepository<ItemPedidos, UUID> {

    List<ItemPedidos> findByIdProduto(Produto idProduto);
    List<ItemPedidos> findByIdPedido(Pedido idPedido);
}
