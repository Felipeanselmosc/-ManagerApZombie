package com.example.demo.controller;

import com.example.demo.model.Feature;
import com.example.demo.repository.FeatureRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("features")
@Slf4j
public class FeatureController {

    @Autowired
    private FeatureRepository featureRepository;

    @GetMapping
    public List<Feature> index() {
        return featureRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feature create(@RequestBody @Valid Feature feature) {
        log.info("criando feature " + feature);
        return featureRepository.save(feature);
    }

    @GetMapping("{id}")
    public Feature get(@PathVariable Long id) {
        log.info("buscando feature com id " + id);
        return getFeatureById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando feature com id {}", id);
        featureRepository.delete(getFeatureById(id));
    }

    @PutMapping("{id}")
    public Feature update(@RequestBody @Valid Feature featureUpdated, @PathVariable Long id) {
        log.info("atualizando feature {} com id {}", featureUpdated, id);
        getFeatureById(id);
        featureUpdated.setId(id);
        return featureRepository.save(featureUpdated);
    }

    private Feature getFeatureById(Long id) {
        return featureRepository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Feature não encontrada com id " + id)
                );
    }
}