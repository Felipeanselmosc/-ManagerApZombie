package com.example.demo.controller;

import com.example.demo.model.Fortification;
import com.example.demo.repository.FortificationRepository;
import com.example.demo.specification.FortificationSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fortifications")
public class FortificationController {

    @Autowired
    private FortificationRepository fortificationRepository;

    @GetMapping
    public Page<Fortification> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer minIntegrity,
            @RequestParam(required = false) Integer maxIntegrity
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Fortification> spec = FortificationSpecification.build(type, minIntegrity, maxIntegrity);
        return fortificationRepository.findAll(spec, pageable);
    }
}
