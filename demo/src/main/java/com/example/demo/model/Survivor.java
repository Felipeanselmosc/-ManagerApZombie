package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Survivor {
    private Long id;
    private String name;
    private Integer age;
    private String skills;
    private Integer health;
    private Integer saniti;

}
