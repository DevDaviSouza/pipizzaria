package com.pizzadelivery.pipizaria.pedido;

import com.pizzadelivery.pipizaria.atendente.Atendente;
import com.pizzadelivery.pipizaria.atendente.AtendenteRepository;
import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.cliente.ClienteRepository;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidos;
import com.pizzadelivery.pipizaria.status_pedidos.StatusPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/pedidos")
@RestController
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    AtendenteRepository atendenteRepository;

    @Autowired
    StatusPedidosRepository statusPedidosRepository;

    //adicionar um pedido
    @PostMapping("/{id}")
    public ResponseEntity<Object> cadastrarPedido(@PathVariable(value = "id") UUID id, @RequestBody PedidoRecordDto pedidoRecordDto) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        Optional<StatusPedidos> status = statusPedidosRepository.findById(pedidoRecordDto.status());

        if (cliente.isPresent()) {
            Cliente novoCliente = cliente.get();

            if (status.isPresent()) {
                StatusPedidos status0 = status.get();
                Pedido pedido = this.pedidoService.CriarPedido(pedidoRecordDto, status0, novoCliente);
                return ResponseEntity.status(HttpStatus.OK).body(pedido);
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Status do pedido não encontrado");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //listar todos os pedidos
    @GetMapping()
    public ResponseEntity<List<Pedido>> ListarTodosPedidos() {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.findAll());
    }

    // listar pedidos filtrando por cliente
    @GetMapping("/{clienteId}")
    public ResponseEntity<List<PedidoData>> listarPedidosDeUmCliente(@PathVariable Cliente clienteId) {
       List<PedidoData> pedidoLista = pedidoService.listarPedidosPorCliente(clienteId);

       return ResponseEntity.ok(pedidoLista);
    }

    //listar pedidos filtrando por status
    @GetMapping("/{id}/status")
    public ResponseEntity<List<PedidoData>> listarPedidosPorStatus(@PathVariable StatusPedidos id) {
        List<PedidoData> pedidoLista = pedidoService.listarPedidosPorStatus(id);

        return ResponseEntity.ok(pedidoLista);
    }

    //exluir pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPedido(@PathVariable UUID id) {
        Optional<Pedido> pedido0 = pedidoRepository.findById(id);

        if (pedido0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }

        pedidoRepository.delete(pedido0.get());

        return ResponseEntity.status(HttpStatus.OK).body("Pedido excluido com sucesso");
    }

    @PutMapping("/{id}/aceitar")
    public ResponseEntity<Object> confirmarPedido(@PathVariable UUID id, @RequestBody PedidoRecordDto pedidoRecordDto) {
        Optional<Pedido> pedido0 = pedidoRepository.findById(id);

        if (pedido0.isPresent()){
            Pedido pedido = pedido0.get();

            Optional<Atendente> atendente0 = atendenteRepository.findById(pedidoRecordDto.idAtendente());

            if (atendente0.isPresent()){
                Atendente atendente = atendente0.get();
                pedido.setIdAtendente(atendente);
            } else {
                return ResponseEntity.badRequest().body("atendente não encontrado no corpo da requisição");
            }

            pedidoRepository.save(pedido);
            return ResponseEntity.ok(pedido);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/alterarStatus")
    public ResponseEntity<Object> alterarStatusPedido(@PathVariable UUID id, @RequestBody PedidoRecordDto pedidoRecordDto) {
        Optional<Pedido> pedido0 = pedidoRepository.findById(id);

        if (pedido0.isPresent()) {
            Pedido pedido = pedido0.get();

            Optional<StatusPedidos> status = statusPedidosRepository.findById(pedidoRecordDto.status());

            if (status.isPresent()) {
                StatusPedidos status0 = status.get();
                pedido.setSituacaoPedido(status0);
            }

            pedidoRepository.save(pedido);
            ResponseEntity.ok("status alterado com sucesso");
        }

        return ResponseEntity.notFound().build();
    }
}