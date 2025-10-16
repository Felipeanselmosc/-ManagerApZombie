package com.example.demo.controller;

import com.example.demo.model.Feature;
import com.example.demo.repository.FeatureRepository;
import com.example.demo.specification.FeatureSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private FeatureRepository featureRepository;

    @GetMapping
    public Page<Feature> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer minQuantity,
            @RequestParam(required = false) Integer maxQuantity
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Feature> spec = FeatureSpecification.build(type, minQuantity, maxQuantity);
        return featureRepository.findAll(spec, pageable);
    }
}
