package com.example.demo.controller;

import com.example.demo.model.Fortification;
import com.example.demo.repository.FortificationRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("fortifications")
@Slf4j
public class FortificationController {

    @Autowired
    private FortificationRepository fortificationRepository;

    @GetMapping
    public List<Fortification> index() {
        return fortificationRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fortification create(@RequestBody @Valid Fortification fortification) {
        log.info("criando fortification " + fortification);
        return fortificationRepository.save(fortification);
    }

    @GetMapping("{id}")
    public Fortification get(@PathVariable Long id) {
        log.info("buscando fortification com id " + id);
        return getFortificationById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando fortification com id {}", id);
        fortificationRepository.delete(getFortificationById(id));
    }

    @PutMapping("{id}")
    public Fortification update(@RequestBody @Valid Fortification fortificationUpdated, @PathVariable Long id) {
        log.info("atualizando fortification {} com id {}", fortificationUpdated, id);
        getFortificationById(id);
        fortificationUpdated.setId(id);
        return fortificationRepository.save(fortificationUpdated);
    }

    private Fortification getFortificationById(Long id) {
        return fortificationRepository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fortification não encontrada com id " + id)
                );
    }
}