package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Feature;
import com.example.demo.model.Fortification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fortifications")
@Slf4j
public class FortificationController {
    private List<Fortification> repository = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Fortification> create(@RequestBody Fortification fortification) {
        log.info("criando fortification: " + fortification.getType());
        repository.add(fortification);
        return ResponseEntity.status(HttpStatus.CREATED).body(fortification);
    }

    @GetMapping
    public List<Fortification> index() {
        log.info("listando todas as fortifications");
        return repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fortification> get(@PathVariable Long id) {
        log.info("buscando fortification com id " + id);
        var fortificationFound = getFortificationById(id);
        if (fortificationFound.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(fortificationFound.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fortification> update(@PathVariable Long id, @RequestBody Fortification fortificationUpdate) {
        log.info("atualizando fortification com id {} ", id);
        var fortificationFound = getFortificationById(id);
        if (fortificationFound.isEmpty()) return ResponseEntity.notFound().build();
        
        repository.remove(fortificationFound.get());
        fortificationUpdate.setId(id);
        repository.add(fortificationUpdate);
        return ResponseEntity.ok(fortificationUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando fortification com id " + id);
        var fortificationFound = getFortificationById(id);
        if (fortificationFound.isEmpty()) return ResponseEntity.notFound().build();
        
        repository.removeIf(fortification -> fortification.getId().equals(id));
        return ResponseEntity.noContent().build();
    }

     private Optional<Fortification> getFortificationById(Long id) {
           var fortificationFound = repository.stream()
            .filter(fortification -> fortification.getId().equals(id))
            .findFirst();
        return fortificationFound;
    }
}