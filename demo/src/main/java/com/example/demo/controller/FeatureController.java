package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.Random;

import com.example.demo.model.Feature;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/features")
@Slf4j
public class FeatureController {

    private List<Feature> repository = new ArrayList<>();

    @GetMapping
    public List<Feature> index() {
        return repository;
    }

     @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Feature create(@RequestBody Feature feature){
        feature.setId(Math.abs(new Random().nextLong()));
        log.info("created feature " + feature);
        repository.add(feature);
        return feature;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> get(@PathVariable Long id) {
        log.info("buscando feature com id " + id);
        var featureFound = getFeatureById(id);
        if (featureFound.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(featureFound.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando feature com id {} " + id);
        var featureFound = getFeatureById(id);
        if (featureFound.isEmpty()) return ResponseEntity.notFound().build();
        repository.remove(featureFound.get());
        return ResponseEntity.noContent().build();
    }

     @PutMapping("/{id}")
    public ResponseEntity<Feature> update(@PathVariable Long id, @RequestBody Feature featureUpdate) {
        log.info("atualizando feature com id {} ", id);
        var featureFound = getFeatureById(id);
        if (featureFound.isEmpty()) return ResponseEntity.notFound().build();
        
        repository.remove(featureFound.get());
        featureUpdate.setId(id);
        repository.add(featureUpdate);
        return ResponseEntity.ok(featureUpdate);
    }

    private Optional<Feature> getFeatureById(Long id) {
           var featureFound = repository.stream()
            .filter(feature -> feature.getId().equals(id))
            .findFirst();
        return featureFound;
    }
}