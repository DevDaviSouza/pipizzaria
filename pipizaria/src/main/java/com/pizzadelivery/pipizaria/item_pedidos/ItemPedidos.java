package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//criacao da entidade itemPedidos com seus atributos e construtores
@Entity
@Table(name = "item_pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "quantidade_itens", nullable = false)
    private int qtdItens;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto idProduto;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido idPedido;

    public ItemPedidos(int qtdItens, Produto idProduto, Pedido idPedido) {
        this.qtdItens = qtdItens;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
    }
}
