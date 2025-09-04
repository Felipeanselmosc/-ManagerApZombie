package com.example.demo.controller;

import com.example.demo.model.Feature;
import com.example.demo.repository.FeatureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
@Slf4j
public class FeatureController {

    private final FeatureRepository repository;

    public FeatureController(FeatureRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Feature> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Feature create(@RequestBody Feature feature) {
        log.info("created feature {}", feature);
        return repository.save(feature);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> get(@PathVariable Long id) {
        log.info("buscando feature com id {}", id);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feature> update(@PathVariable Long id, @RequestBody Feature featureUpdate) {
        log.info("atualizando feature com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    featureUpdate.setId(id);
                    return ResponseEntity.ok(repository.save(featureUpdate));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando feature com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    repository.delete(existing);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
