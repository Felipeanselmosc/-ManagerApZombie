package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Feature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/features")
public class FeatureController {
    
    @GetMapping
    public List<Feature> index(){
        List<Feature> features = new ArrayList<>();
        return features;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Feature controller activated!";
    }
}
