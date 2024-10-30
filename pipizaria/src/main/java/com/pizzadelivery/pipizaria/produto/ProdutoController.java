package com.pizzadelivery.pipizaria.produto;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//criacao de um controller junto com sua rota base
@RequestMapping("/produto")
@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    //metodo para cadastrar novo produto
    @PostMapping()
    public ResponseEntity<Produto> novoProduto(@RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
        var produto = new Produto();

        BeanUtils.copyProperties(produtoRecordDto, produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    //metodo para buscar um produto com base em seu ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProdutoUnico(@PathVariable(value = "id") UUID id) {
        Optional<Produto> produto0 = produtoRepository.findById(id);

        if (produto0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(produto0.get());
    }

    // metodo que lista todos os produtos
    @GetMapping()
    public ResponseEntity<List<Produto>> getTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }

    //metodo que altera um produto com base em seu ID
    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable(value = "id") UUID id, @RequestBody ProdutoRecordDto produtoRecordDto ) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var produtoSave = produto.get();
        BeanUtils.copyProperties(produtoRecordDto, produtoSave);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtoSave));
    }

    //metodo que deleta um produto com base em seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleterProduto(@PathVariable(value = "id") UUID id) {
        Optional<Produto> produto0 = produtoRepository.findById(id);

        if (produto0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        produtoRepository.delete(produto0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}
