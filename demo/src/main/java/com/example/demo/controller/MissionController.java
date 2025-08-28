package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Mission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/missions")
public class MissionController {

    @GetMapping
    public List<Mission> index(){
        List<Mission> missions = new ArrayList<>();
        return missions;
    }
}