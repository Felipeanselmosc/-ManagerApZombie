package com.example.demo.controller;

import com.example.demo.model.Mission;
import com.example.demo.repository.MissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@Slf4j
public class MissionController {

    private final MissionRepository repository;

    public MissionController(MissionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Mission> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mission create(@RequestBody Mission mission) {
        log.info("created mission {}", mission);
        return repository.save(mission);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> get(@PathVariable Long id) {
        log.info("buscando mission com id {}", id);
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mission> update(@PathVariable Long id, @RequestBody Mission missionUpdate) {
        log.info("atualizando mission com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    missionUpdate.setId(id);
                    return ResponseEntity.ok(repository.save(missionUpdate));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("deletando mission com id {}", id);
        return repository.findById(id)
                .map(existing -> {
                    repository.delete(existing);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}