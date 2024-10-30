package com.pizzadelivery.pipizaria.atendente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//classe Interface para criação de repositorio e herdar funcionalidades do JpaRepository
@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, UUID> {
}
