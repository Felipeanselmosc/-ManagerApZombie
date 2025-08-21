package com.example.demo.model;

public class Fortification {
    private Long id;
    private String type;
    private Integer level;
    private Integer integrity;
    private Integer maintenanceCost;
    
    public Fortification(Long id, String type, Integer level, Integer integrity, Integer maintenanceCost) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.integrity = integrity;
        this.maintenanceCost = maintenanceCost;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Integer integrity) {
        this.integrity = integrity;
    }

    public Integer getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Integer maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    



}
