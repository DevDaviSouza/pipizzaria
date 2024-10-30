package com.pizzadelivery.pipizaria.atendente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//criacao da entidade atendente com seus atributos
@Entity
@Table(name = "atendente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_atendente", nullable = false)
    private String nomeAtendente;

    @Column(name = "login_atendente", nullable = false)
    private String loginAtendente;

    @Column(name = "senha_atendente", nullable = false)
    private String senhaAtendente;

    @Column(name = "email_atendente", nullable = false)
    private String emailAtendente;
}
