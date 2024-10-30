package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    List<Pedido> findByIdCliente (Cliente idCliente);
    List<Pedido> findByIdStatus (StatusPedidos idStatus);
}
