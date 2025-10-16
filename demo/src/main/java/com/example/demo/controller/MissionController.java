package com.example.demo.controller;

import com.example.demo.model.Mission;
import com.example.demo.repository.MissionRepository;
import com.example.demo.specification.MissionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
public class MissionController {

    @Autowired
    private MissionRepository missionRepository;

    @GetMapping
    public Page<Mission> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String status
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Mission> spec = MissionSpecification.build(type, location, status);
        return missionRepository.findAll(spec, pageable);
    }
}
