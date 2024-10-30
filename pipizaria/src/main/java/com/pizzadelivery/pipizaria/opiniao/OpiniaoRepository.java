package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//classe Interface para criação de repositorio e herdar funcionalidades do JpaRepository
@Repository
public interface OpiniaoRepository extends JpaRepository<Opiniao, UUID> {
    //metodo que faz a requisição para listar as opinioes por id do cliente.
    List<Opiniao> findByIdCliente(Cliente cliente);
}
