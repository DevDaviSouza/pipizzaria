package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OpiniaoRepository extends JpaRepository<Opiniao, UUID> {
    List<Opiniao> findByIdCliente(Cliente cliente);
}
