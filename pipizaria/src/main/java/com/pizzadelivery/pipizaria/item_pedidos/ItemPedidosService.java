package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//arquivo service para implementação da logica necessária para requisições e cadastros personalizados
@Service
public class ItemPedidosService {

    @Autowired
    ItemPedidosRepository itemPedidosRepository;

    //metodo que cria o itemPedido com base no construtor criado na entidade
    public ItemPedidos criarPedido(ItemPedidosRecordDto itemPedidosRecordDto, Produto produto, Pedido pedido) {
        ItemPedidos itemPedidos = new ItemPedidos(itemPedidosRecordDto.qtdItens(), produto, pedido);

        itemPedidosRepository.save(itemPedidos);

        return itemPedidos;
    }

    //metodo que lista itemPedidos com base no id do produto(utilizado no controller)
    public List<ItemPedidosData> listarPorIdProduto(Produto idProduto) {
        return itemPedidosRepository.findByIdProduto(idProduto).stream().map(itemPedidos -> new ItemPedidosData(itemPedidos.getId(), itemPedidos.getQtdItens(), itemPedidos.getIdProduto(), itemPedidos.getIdPedido())).toList();
    }

    //metodo que lista itemPedidos com base no id do pedido(utilizado no controller)
    public List<ItemPedidosData> listarPorIdPedido(Pedido idPedido) {
        return itemPedidosRepository.findByIdPedido(idPedido).stream().map(itemPedidos -> new ItemPedidosData(itemPedidos.getId(), itemPedidos.getQtdItens(), itemPedidos.getIdProduto(), itemPedidos.getIdPedido())).toList();
    }
}
