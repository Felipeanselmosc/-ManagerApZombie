package com.example.demo.model;

public class Threat {
    private Long id;
    private String type;
    private String intensity;
    private String location;
    private Integer timeToAttack;
    public Threat(Long id, String type, String intensity, String location, Integer timeToAttack) {
        this.id = id;
        this.type = type;
        this.intensity = intensity;
        this.location = location;
        this.timeToAttack = timeToAttack;
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
    public String getIntensity() {
        return intensity;
    }
    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getTimeToAttack() {
        return timeToAttack;
    }
    public void setTimeToAttack(Integer timeToAttack) {
        this.timeToAttack = timeToAttack;
    }
    
    
    
    
}
