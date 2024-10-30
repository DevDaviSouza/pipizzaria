package com.pizzadelivery.pipizaria.status_pedidos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//classe Interface para criação de repositorio e herdar funcionalidades do JpaRepository
@Repository
public interface StatusPedidosRepository extends JpaRepository<StatusPedidos, UUID> {}
