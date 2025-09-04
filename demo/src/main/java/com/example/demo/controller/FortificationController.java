package com.example.demo.controller;

import com.example.demo.model.Fortification;
import com.example.demo.repository.FortificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fortifications")
@Slf4j
public class FortificationController {

    private final FortificationRepository repository;

    public FortificationController(FortificationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Fortification> create(@RequestBody Fortification fortification) {
        log.info("criando fortification: {}", fortification.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(fortification));
    }

    @GetMapping
    public List<Fortification> index() {
        log.info("listando todas as fortifications");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fortification> get(@PathVariable Long id) {
        log.info("buscando fortification com id {}", id);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fortification> update(@PathVariable Long id, @RequestBody Fortification fortificationUpdate) {
        log.info("atualizando fortification com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    fortificationUpdate.setId(id);
                    return ResponseEntity.ok(repository.save(fortificationUpdate));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando fortification com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    repository.delete(existing);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
