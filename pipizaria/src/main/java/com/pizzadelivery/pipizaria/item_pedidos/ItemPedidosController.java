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

//criacao de um controller junto com sua rota base
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

    //metodo para criar um novo itemPedido(adicionar um item ao pedido criado)
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

    //metodo para listar todos os itensPedidos(para fins de relatórios de itens vendidos)
    @GetMapping()
    public ResponseEntity<List<ItemPedidos>> listarTodosItemPedidos() {
        List<ItemPedidos> lista = itemPedidosRepository.findAll();

        return ResponseEntity.ok(lista);
    }

    //metodo que exclui um item do pedido com base em seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirItemPedidos(@PathVariable UUID id) {
        Optional<ItemPedidos> itemPedidos = itemPedidosRepository.findById(id);

        if (itemPedidos.isPresent()) {
            itemPedidosRepository.delete(itemPedidos.get());

            return ResponseEntity.ok("item excluido com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item-pedido não encontrado...");
    }

    //metodo que lista todos os itemPedidos por meio do ID do produto(para fins de relatório)
    @GetMapping("/{id}/produto")
    public ResponseEntity<List<ItemPedidosData>> listarItemPedidosPorProduto(@PathVariable Produto id) {
        List<ItemPedidosData> itemPedidoLista = itemPedidosService.listarPorIdProduto(id);

        return ResponseEntity.ok(itemPedidoLista);
    }

    // metodo que lista todos os itemPedidos por meio do ID do pedido(para fins de relatorio e visualizaçao do cliente)
    @GetMapping("/{id}/pedido")
    public ResponseEntity<List<ItemPedidosData>> listarItemPedidosPorPedido(@PathVariable Pedido id) {
        List<ItemPedidosData> itemPedidoLista = itemPedidosService.listarPorIdPedido(id);

        return ResponseEntity.ok(itemPedidoLista);
    }

    //metodo que altera a quantidade dos itens no itemPedidos
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
