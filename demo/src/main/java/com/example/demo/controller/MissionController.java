package com.example.demo.controller;

import com.example.demo.model.Mission;
import com.example.demo.repository.MissionRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("missions")
@Slf4j
public class MissionController {

    @Autowired
    private MissionRepository missionRepository;

    @GetMapping
    public List<Mission> index() {
        return missionRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mission create(@RequestBody @Valid Mission mission) {
        log.info("criando mission " + mission);
        return missionRepository.save(mission);
    }

    @GetMapping("{id}")
    public Mission get(@PathVariable Long id) {
        log.info("buscando mission com id " + id);
        return getMissionById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando mission com id {}", id);
        missionRepository.delete(getMissionById(id));
    }

    @PutMapping("{id}")
    public Mission update(@RequestBody @Valid Mission missionUpdated, @PathVariable Long id) {
        log.info("atualizando mission {} com id {}", missionUpdated, id);
        getMissionById(id);
        missionUpdated.setId(id);
        return missionRepository.save(missionUpdated);
    }

    private Mission getMissionById(Long id) {
        return missionRepository
                .findById(id)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mission não encontrada com id " + id)
                );
    }
}