package com.example.demo.controller;

import com.example.demo.model.Threat;
import com.example.demo.repository.ThreatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/threats")
@Slf4j
public class ThreatController {

    private final ThreatRepository repository;

    public ThreatController(ThreatRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Threat> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Threat create(@RequestBody Threat threat) {
        log.info("created threat {}", threat);
        return repository.save(threat);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Threat> get(@PathVariable Long id) {
        log.info("buscando threat com id {}", id);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Threat> update(@PathVariable Long id, @RequestBody Threat threatUpdate) {
        log.info("atualizando threat com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    threatUpdate.setId(id);
                    return ResponseEntity.ok(repository.save(threatUpdate));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando threat com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    repository.delete(existing);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}