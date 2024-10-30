package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.atendente.Atendente;
import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

//criacao da entidade pedido com seus atributos e construtores
@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "numero_pedido", nullable = false)
    private int numeroPedido;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private StatusPedidos idStatus;

    @ManyToOne
    @JoinColumn(name = "id_cliente",nullable = false)
    private Cliente idCliente;

    @Setter
    @ManyToOne
    @JoinColumn(name = "id_atendente")
    private Atendente idAtendente;

    public Pedido(int numeroPedido, LocalDateTime dataPedido, StatusPedidos idStatus, Cliente idCliente) {
        this.numeroPedido = numeroPedido;
        this.dataPedido = dataPedido;
        this.idStatus = idStatus;
        this.idCliente = idCliente;
    }

    public String setSituacaoPedido(StatusPedidos idStatus) {
        this.idStatus = idStatus;
        return "status alterado";
    }
}