package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mission {
    private Long id;
    private String type;
    private String location;
    private String riskLevel;
    private String participants;
    private String expectedResources;
    private String status;

}
