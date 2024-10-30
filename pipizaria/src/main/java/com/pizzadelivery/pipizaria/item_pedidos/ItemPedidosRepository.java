package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

//classe Interface para criação de repositorio e herdar funcionalidades do JpaRepository
public interface ItemPedidosRepository extends JpaRepository<ItemPedidos, UUID> {

    //metodo que faz requisição e lista com base no id do produto
    List<ItemPedidos> findByIdProduto(Produto idProduto);
    //metodo que faz requisição e lista com base no id do pedido
    List<ItemPedidos> findByIdPedido(Pedido idPedido);
}
