package com.pizzadelivery.pipizaria.produto;

import jakarta.validation.constraints.NotNull;

//classe record para transferência de dados
public record ProdutoRecordDto(@NotNull String descricaoProduto, @NotNull double valorProduto) {
}
