package com.pizzadelivery.pipizaria.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//classe Interface para criação de repositorio e herdar funcionalidades do JpaRepository
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {}
