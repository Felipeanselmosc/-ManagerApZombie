package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Threat {
    private Long id;
    private String type;
    private String intensity;
    private String location;
    private Integer timeToAttack;
    
}
