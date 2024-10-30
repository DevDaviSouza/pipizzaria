package com.pizzadelivery.pipizaria.atendente;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/atendente")
@RestController
public class AtendenteController {

    @Autowired
    AtendenteRepository atendenteRepository;

    @PostMapping()
    public ResponseEntity<Atendente> cadatrarAtendente(@RequestBody @Valid AtendenteRecordDto atendenteRecordDto) {
        var atendente = new Atendente();

        BeanUtils.copyProperties(atendenteRecordDto, atendente);

        return ResponseEntity.status(HttpStatus.OK).body(atendenteRepository.save(atendente));
    }

    @GetMapping()
    public ResponseEntity<List<Atendente>> listarTodosAtendentes() {
        return ResponseEntity.status(HttpStatus.OK).body(atendenteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAtendentePorId(@PathVariable(value = "id")UUID id) {
        Optional<Atendente> atendente0 = atendenteRepository.findById(id);

        return atendente0.<ResponseEntity<Object>>map(atendente -> ResponseEntity.status(HttpStatus.OK).body(atendente)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atendente não encontrado!"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarAtendente(@PathVariable(value = "id") UUID id, @RequestBody AtendenteRecordDto atendenteRecordDto) {
        Optional<Atendente> atendente0 = atendenteRepository.findById(id);

        if (atendente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atendente não encontrado!");
        }

        var atendenteSave = atendente0.get();

        BeanUtils.copyProperties(atendenteRecordDto, atendenteSave);
        return ResponseEntity.status(HttpStatus.OK).body(atendenteRepository.save(atendenteSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAtendente(@PathVariable(value = "id") UUID id) {
        Optional<Atendente> atendente0 = atendenteRepository.findById(id);

        atendenteRepository.delete(atendente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Atendente deletado com sucesso!");
    }
}
