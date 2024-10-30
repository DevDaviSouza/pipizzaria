package com.pizzadelivery.pipizaria.cliente;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//criacao de um controller junto com sua rota base
@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    //metodo que cria um cliente (cadastrar)
    @PostMapping()
    public ResponseEntity<Object> criarCliente(@RequestBody ClienteRecordDto clienteRecordDto) {
        var cliente = new Cliente();

        BeanUtils.copyProperties(clienteRecordDto, cliente);

        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
    }

    //metodo que busca o cliente com base em seu ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarClientePorId(@PathVariable(value = "id") UUID id) {
        Optional<Cliente> cliente0 = clienteRepository.findById(id);

        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cliente0.get());
    }

    // metodo que lista todos os clientes cadastrados
    @GetMapping()
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        var clientes = clienteRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    //metodo que altera o cliente com base em seu ID
    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarCliente(@PathVariable(value = "id") UUID id, @RequestBody ClienteRecordDto clienteRecordDto) {
        Optional<Cliente> cliente0 = clienteRepository.findById(id);

        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        var clienteSave = cliente0.get();

        BeanUtils.copyProperties(clienteRecordDto, clienteSave);

        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteSave));
    }

    //metodo que deleta o cliente com base em seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable(value = "id") UUID id) {
        Optional<Cliente> cliente0 = clienteRepository.findById(id);

        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }

        clienteRepository.delete(cliente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso!");
    }
}