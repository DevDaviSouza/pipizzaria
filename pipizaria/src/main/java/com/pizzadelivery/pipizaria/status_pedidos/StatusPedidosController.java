package com.pizzadelivery.pipizaria.status_pedidos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//criacao de um controller junto com sua rota base
@RequestMapping("/status")
@RestController
public class StatusPedidosController {

    @Autowired
    StatusPedidosRepository statusPedidosRepository;

    //metodo para cadastrar os status
    @PostMapping()
    public ResponseEntity<StatusPedidos> cadastrarNovoStatus(@RequestBody StatusPedidosRecordDto statusPedidosRecordDto) {
        var status = new StatusPedidos();

        BeanUtils.copyProperties(statusPedidosRecordDto, status);

        return ResponseEntity.ok(statusPedidosRepository.save(status));
    }

    // metodo que lista todos os status para fins de consulta
    @GetMapping()
    public ResponseEntity<List<StatusPedidos>> listarTodosStatus() {
        List<StatusPedidos> status = statusPedidosRepository.findAll();

        return ResponseEntity.ok(status);
    }
}
