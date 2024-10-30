package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//classe Interface para criação de repositorio e herdar funcionalidades do JpaRepository
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    //metodo que faz a requisição para listar os pedidos por id do cliente.
    List<Pedido> findByIdCliente (Cliente idCliente);
    //metodo que faz a requisição para listar os pedidos por id do status.
    List<Pedido> findByIdStatus (StatusPedidos idStatus);
}
