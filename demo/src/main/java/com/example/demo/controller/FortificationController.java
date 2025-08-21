package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Fortification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fortifications")
public class FortificationController {

    @GetMapping
    public List<Fortification> index(){
        List<Fortification> fortifications = new ArrayList<>();
        return fortifications;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Fortification controller activated!";
    }
}
