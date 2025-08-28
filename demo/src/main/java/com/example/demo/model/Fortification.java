package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fortification {
    private Long id;
    private String type;
    private Integer level;
    private Integer integrity;
    private Integer maintenanceCost;
}
