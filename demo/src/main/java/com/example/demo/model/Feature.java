package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Feature {
   private Long id;
   private String type;
   private Integer quantity;
    
}
