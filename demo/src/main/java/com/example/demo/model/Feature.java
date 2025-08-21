package com.example.demo.model;

public class Feature {
   private Long id;
   private String type;
   private Integer quantity;

   public Feature(Long id, String type, Integer quantity) {
    this.id = id;
    this.type = type;
    this.quantity = quantity;
   }

   public Long getId() {
    return id;
   }

   public void setId(Long id) {
    this.id = id;
   }

   public String getType() {
    return type;
   }

   public void setType(String type) {
    this.type = type;
   }

   public Integer getQuantity() {
    return quantity;
   }

   public void setQuantity(Integer quantity) {
    this.quantity = quantity;
   }

   

   
    
}
