package com.pizzadelivery.pipizaria.produto;

import jakarta.validation.constraints.NotNull;

public record ProdutoRecordDto(@NotNull String descricaoProduto, @NotNull double valorProduto) {
}
