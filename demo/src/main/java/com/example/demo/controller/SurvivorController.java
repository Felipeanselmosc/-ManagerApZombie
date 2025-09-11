package com.example.demo.controller;

import com.example.demo.model.Survivor;
import com.example.demo.repository.SurvivorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survivors")
@Slf4j
public class SurvivorController {

    private final SurvivorRepository repository;

    public SurvivorController(SurvivorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Survivor> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Survivor create(@RequestBody Survivor survivor) {
        log.info("created survivor {}", survivor);
        return repository.save(survivor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survivor> get(@PathVariable Long id) {
        log.info("buscando survivor com id {}", id);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survivor> update(@PathVariable Long id, @RequestBody Survivor survivorUpdate) {
        log.info("atualizando survivor com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    survivorUpdate.setId(id);
                    return ResponseEntity.ok(repository.save(survivorUpdate));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando survivor com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    repository.delete(existing);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}