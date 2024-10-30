package com.pizzadelivery.pipizaria.status_pedidos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/status")
@RestController
public class StatusPedidosController {

    @Autowired
    StatusPedidosRepository statusPedidosRepository;

    @PostMapping()
    public ResponseEntity<StatusPedidos> cadastrarNovoStatus(@RequestBody StatusPedidosRecordDto statusPedidosRecordDto) {
        var status = new StatusPedidos();

        BeanUtils.copyProperties(statusPedidosRecordDto, status);

        return ResponseEntity.ok(statusPedidosRepository.save(status));
    }

    @GetMapping()
    public ResponseEntity<List<StatusPedidos>> listarTodosStatus() {
        List<StatusPedidos> status = statusPedidosRepository.findAll();

        return ResponseEntity.ok(status);
    }
}
