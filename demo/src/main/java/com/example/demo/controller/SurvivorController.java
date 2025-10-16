package com.example.demo.controller;

import com.example.demo.model.Survivor;
import com.example.demo.repository.SurvivorRepository;
import com.example.demo.specification.SurvivorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survivors")
public class SurvivorController {

    @Autowired
    private SurvivorRepository survivorRepository;

    @GetMapping
    public Page<Survivor> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String skill,
            @RequestParam(required = false) Integer minHealth,
            @RequestParam(required = false) Integer maxHealth
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Survivor> spec = SurvivorSpecification.build(name, skill, minHealth, maxHealth);
        return survivorRepository.findAll(spec, pageable);
    }
}
