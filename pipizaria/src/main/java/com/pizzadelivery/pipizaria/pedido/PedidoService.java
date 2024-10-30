package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.cliente.ClienteRepository;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//arquivo service para implementação da logica necessária para requisições e cadastros personalizados
@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    //metodo que cria um pedido com base no endpoint da entidade
    public Pedido CriarPedido(PedidoRecordDto pedidoRecordDto, StatusPedidos status, Cliente cliente) {

        Pedido pedido = new Pedido(pedidoRecordDto.numeroPedido(), pedidoRecordDto.dataPedido(), status, cliente);
        repository.save(pedido);

        return pedido;
    }

    //metodo que lista todos os pedidos de um cliente
    public List<PedidoData> listarPedidosPorCliente(Cliente idCliente) {
        return repository.findByIdCliente(idCliente).stream().map(pedido -> new PedidoData(pedido.getId(),pedido.getNumeroPedido(),pedido.getDataPedido())).toList();
    }

    //metodo que lista todos os pedidos com base nos status
    public List<PedidoData> listarPedidosPorStatus(StatusPedidos idStatus) {
        return repository.findByIdStatus(idStatus).stream().map(pedido -> new PedidoData(pedido.getId(), pedido.getNumeroPedido(), pedido.getDataPedido())).toList();
    }
}