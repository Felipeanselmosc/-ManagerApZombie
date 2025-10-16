package com.example.demo.controller;

import com.example.demo.model.Threat;
import com.example.demo.repository.ThreatRepository;
import com.example.demo.specification.ThreatSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/threats")
public class ThreatController {

    @Autowired
    private ThreatRepository threatRepository;

    @GetMapping
    public Page<Threat> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Integer minIntensity,
            @RequestParam(required = false) Integer maxIntensity
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Threat> spec = ThreatSpecification.build(type, location, minIntensity, maxIntensity);
        return threatRepository.findAll(spec, pageable);
    }
}
