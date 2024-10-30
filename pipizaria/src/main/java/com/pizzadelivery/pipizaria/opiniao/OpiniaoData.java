package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.pedido.Pedido;

import java.util.UUID;

//classe record para transferência de dados e manipulação de retorno dos endpoints(metodos)
public record OpiniaoData(UUID id, String descricaoOpiniao, Cliente idCliente, Pedido idPedido) {
}
