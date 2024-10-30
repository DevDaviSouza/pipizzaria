package com.pizzadelivery.pipizaria.item_pedidos;

import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.pedido.PedidoRepository;
import com.pizzadelivery.pipizaria.produto.Produto;
import com.pizzadelivery.pipizaria.produto.ProdutoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/itens-pedidos")
@RestController
public class ItemPedidosController {

    @Autowired
    ItemPedidosRepository itemPedidosRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ItemPedidosService itemPedidosService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> criarItemPedido(@PathVariable UUID id, @RequestBody ItemPedidosRecordDto itemPedidosRecordDto) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        Optional<Produto> produto = produtoRepository.findById(itemPedidosRecordDto.idProduto());

        if (pedido.isPresent()) {
            Pedido pedido0 = pedido.get();

            if (produto.isPresent()) {
                Produto produto0 = produto.get();

                ItemPedidos itemPedidos = itemPedidosService.criarPedido(itemPedidosRecordDto, produto0, pedido0);
                return ResponseEntity.ok(itemPedidos);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<ItemPedidos>> listarTodosItemPedidos() {
        List<ItemPedidos> lista = itemPedidosRepository.findAll();

        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirItemPedido(@PathVariable UUID id) {
        Optional<ItemPedidos> itemPedidos = itemPedidosRepository.findById(id);

        if (itemPedidos.isPresent()) {
            itemPedidosRepository.delete(itemPedidos.get());

            return ResponseEntity.ok("item excluido com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item-pedido não encontrado...");
    }

    @GetMapping("/{id}/produto")
    public ResponseEntity<List<ItemPedidosData>> listarItemPedidosPorProduto(@PathVariable Produto id) {
        List<ItemPedidosData> itemPedidoLista = itemPedidosService.listarPorIdProduto(id);

        return ResponseEntity.ok(itemPedidoLista);
    }

    @GetMapping("/{id}/pedido")
    public ResponseEntity<List<ItemPedidosData>> listarItemPedidosPorPedido(@PathVariable Pedido id) {
        List<ItemPedidosData> itemPedidoLista = itemPedidosService.listarPorIdPedido(id);

        return ResponseEntity.ok(itemPedidoLista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarQuantidadeItens(@PathVariable UUID id, @RequestBody ItemPedidosRecordDto itemPedidosRecordDto) {
        Optional<ItemPedidos> itemPedido = itemPedidosRepository.findById(id);

        if (itemPedido.isPresent()){
            ItemPedidos itemPedidos = itemPedido.get();

            itemPedidos.setQtdItens(itemPedidosRecordDto.qtdItens());
            itemPedidosRepository.save(itemPedidos);
            return ResponseEntity.status(HttpStatus.OK).body(itemPedidos);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item-pedido não encontrado");
    }
}
