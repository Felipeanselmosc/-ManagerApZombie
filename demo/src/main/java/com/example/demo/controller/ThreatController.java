package com.example.demo.controller;

import com.example.demo.model.Threat;
import com.example.demo.repository.ThreatRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("threats")
@Slf4j
public class ThreatController {

    @Autowired
    private ThreatRepository threatRepository;

    @GetMapping
    public List<Threat> index() {
        return threatRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Threat create(@RequestBody @Valid Threat threat) {
        log.info("criando threat " + threat);
        return threatRepository.save(threat);
    }

    @GetMapping("{id}")
    public Threat get(@PathVariable Long id) {
        log.info("buscando threat com id " + id);
        return getThreatById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando threat com id {}", id);
        threatRepository.delete(getThreatById(id));
    }

    @PutMapping("{id}")
    public Threat update(@RequestBody @Valid Threat threatUpdated, @PathVariable Long id) {
        log.info("atualizando threat {} com id {}", threatUpdated, id);
        getThreatById(id);
        threatUpdated.setId(id);
        return threatRepository.save(threatUpdated);
    }

    private Threat getThreatById(Long id) {
        return threatRepository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Threat não encontrada com id " + id)
                );
    }
}