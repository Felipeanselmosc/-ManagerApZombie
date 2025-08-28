package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threats")
public class ThreatController {

    @GetMapping
    public List<String> index(){
        List<String> threats = new ArrayList<>();
        return threats;
    }
}
