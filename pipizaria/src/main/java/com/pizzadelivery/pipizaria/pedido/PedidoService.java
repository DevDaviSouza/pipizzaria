package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.cliente.ClienteRepository;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Pedido CriarPedido(PedidoRecordDto pedidoRecordDto, StatusPedidos status, Cliente cliente) {

        Pedido pedido = new Pedido(pedidoRecordDto.numeroPedido(), pedidoRecordDto.dataPedido(), status, cliente);
        repository.save(pedido);

        return pedido;
    }

    public List<PedidoData> listarPedidosPorCliente(Cliente idCliente) {
        return repository.findByIdCliente(idCliente).stream().map(pedido -> new PedidoData(pedido.getId(),pedido.getNumeroPedido(),pedido.getDataPedido())).toList();
    }

    public List<PedidoData> listarPedidosPorStatus(StatusPedidos idStatus) {
        return repository.findByIdStatus(idStatus).stream().map(pedido -> new PedidoData(pedido.getId(), pedido.getNumeroPedido(), pedido.getDataPedido())).toList();
    }
}