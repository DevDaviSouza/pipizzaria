package com.pizzadelivery.pipizaria.status_pedidos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "status_pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatusPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "status", nullable = false)
    private String status;
}
