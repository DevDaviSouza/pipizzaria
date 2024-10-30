package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.pedido.PedidoData;
import com.pizzadelivery.pipizaria.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpiniaoService {

    @Autowired
    OpiniaoRepository opiniaoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public Opiniao cadastrarOpiniao(OpiniaoRecordDto opiniaoRecordDto, Cliente cliente, Pedido pedido) {
        Optional<Pedido> pedido0 = pedidoRepository.findById(pedido.getId());

        Opiniao opiniao = new Opiniao(opiniaoRecordDto.descricaoOpiniao(), cliente, pedido);

        opiniaoRepository.save(opiniao);

        return opiniao;
    }

    public List<OpiniaoData> listarPedidosPorCliente(Cliente idCliente) {
        return opiniaoRepository.findByIdCliente(idCliente).stream().map(opiniao -> new OpiniaoData(opiniao.getId(),opiniao.getDescricaoOpiniao(),opiniao.getIdCliente(), opiniao.getIdPedido())).toList();
    }
}
