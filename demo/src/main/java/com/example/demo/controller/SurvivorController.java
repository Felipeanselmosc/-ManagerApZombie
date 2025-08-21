package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Survivor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survivors")
public class SurvivorController {

    @GetMapping
    public List<Survivor> index(){
        List<Survivor> survivors = new ArrayList<>();
        return survivors;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Survivor controller activated!";
    }
}
