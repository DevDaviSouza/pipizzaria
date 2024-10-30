package com.pizzadelivery.pipizaria.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//criacao da entidade cliente com seus atributos
@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_cliente", nullable = false)
    private String nomeCliente;

    @Column(name = "login_cliente", nullable = false)
    private String loginCliente;

    @Column(name = "senha_cliente", nullable = false)
    private String senhaCliente;

    @Column(name = "email_cliente", nullable = false)
    private String emailCliente;

    @Column(name = "cep_cliente", nullable = false)
    private String cepCliente;

    @Column(name = "rua_cliente", nullable = false)
    private String ruaCliente;

    @Column(name = "bairro_cliente", nullable = false)
    private String bairroCliente;

    @Column(name = "cidade_cliente", nullable = false)
    private String cidadeCliente;

    @Column(name = "UF_cliente", nullable = false)
    private String ufCliente;

    @Column(name = "telefone_cliente", nullable = false)
    private String telefoneCliente;
}
