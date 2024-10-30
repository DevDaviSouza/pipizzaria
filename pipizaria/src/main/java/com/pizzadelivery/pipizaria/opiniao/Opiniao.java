package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.pedido.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//criacao da entidade opiniao com seus atributos e construtor
@Entity
@Table(name = "opiniao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Opiniao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "descricao_opiniao", nullable = false)
    private String descricaoOpiniao;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido idPedido;


    public Opiniao(@NotNull String s, Cliente idCliente, Pedido idPedido) {
        this.descricaoOpiniao = s;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
    }
}
