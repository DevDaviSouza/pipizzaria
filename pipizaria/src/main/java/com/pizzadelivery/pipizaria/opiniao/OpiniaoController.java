package com.pizzadelivery.pipizaria.opiniao;

import com.pizzadelivery.pipizaria.cliente.Cliente;
import com.pizzadelivery.pipizaria.cliente.ClienteRepository;
import com.pizzadelivery.pipizaria.pedido.Pedido;
import com.pizzadelivery.pipizaria.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//criacao de um controller junto com sua rota base
@RequestMapping("/opinioes")
@RestController
public class OpiniaoController {

    @Autowired
    OpiniaoRepository opiniaoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    OpiniaoService opiniaoService;

    //metodo para cadastrar uma nova opiniao
    @PostMapping("/{id}")
    public ResponseEntity<Opiniao> cadastrarOpiniao(@PathVariable UUID id, @RequestBody OpiniaoRecordDto opiniaoRecordDto){
        Optional<Pedido> pedido0 = pedidoRepository.findById(id);

        if (pedido0.isPresent()) {
            Pedido pedido = pedido0.get();

            Optional<Cliente> cliente0 = clienteRepository.findById(pedido.getIdCliente().getId());

            Cliente cliente = cliente0.get();

            Opiniao opiniao = opiniaoService.cadastrarOpiniao(opiniaoRecordDto,cliente, pedido);

            return ResponseEntity.ok(opiniao);
        }

        return ResponseEntity.notFound().build();

    }

    //metodo que lista todas as opinioes para fins de relatorio
    @GetMapping()
    public ResponseEntity<List<Opiniao>> listarTodasOpinioes() {
        List<Opiniao> opinioes = opiniaoRepository.findAll();

        return ResponseEntity.ok(opinioes);
    }

    //metodo que lista todas as opinioes de um cliente
    @GetMapping("/{id}")
    public ResponseEntity<List<OpiniaoData>> listarOpinioesPorCliente(@PathVariable Cliente id) {
        List<OpiniaoData> opinioes = opiniaoService.listarPedidosPorCliente(id);

        return ResponseEntity.ok(opinioes);
    }

    //metodo que exclui uma opiniao com base em seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirOpiniao(@PathVariable UUID id) {
        Optional<Opiniao> opiniao0 = opiniaoRepository.findById(id);

        if (opiniao0.isPresent()){

            opiniaoRepository.delete(opiniao0.get());

            return ResponseEntity.ok("Opiniao deletada com sucesso!");
        }

        return ResponseEntity.notFound().build();
    }

    //metodo que altera uma opiniao utilizando seu ID
    @PutMapping("/{id}")
    public ResponseEntity<Opiniao> editarOpiniao(@PathVariable UUID id, @RequestBody OpiniaoRecordDto opiniaoRecordDto) {
        Optional<Opiniao> opiniao0 = opiniaoRepository.findById(id);

        if (opiniao0.isPresent()) {
            Opiniao opiniao = opiniao0.get();

            opiniao.setDescricaoOpiniao(opiniaoRecordDto.descricaoOpiniao());

            opiniaoRepository.save(opiniao);

            return ResponseEntity.ok(opiniao);
        }

        return ResponseEntity.notFound().build();
    }
}
