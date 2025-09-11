package com.example.demo.controller;

import com.example.demo.model.Survivor;
import com.example.demo.repository.SurvivorRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("survivors")
@Slf4j
public class SurvivorController {

    @Autowired
    private SurvivorRepository survivorRepository;

    @GetMapping
    public List<Survivor> index() {
        return survivorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Survivor create(@RequestBody @Valid Survivor survivor) {
        log.info("criando survivor " + survivor);
        return survivorRepository.save(survivor);
    }

    @GetMapping("{id}")
    public Survivor get(@PathVariable Long id) {
        log.info("buscando survivor com id " + id);
        return getSurvivorById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando survivor com id {}", id);
        survivorRepository.delete(getSurvivorById(id));
    }

    @PutMapping("{id}")
    public Survivor update(@RequestBody @Valid Survivor survivorUpdated, @PathVariable Long id) {
        log.info("atualizando survivor {} com id {}", survivorUpdated, id);
        getSurvivorById(id);
        survivorUpdated.setId(id);
        return survivorRepository.save(survivorUpdated);
    }

    private Survivor getSurvivorById(Long id) {
        return survivorRepository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Survivor não encontrado com id " + id)
                );
    }
}