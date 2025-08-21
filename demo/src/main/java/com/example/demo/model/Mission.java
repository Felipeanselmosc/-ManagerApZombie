package com.example.demo.model;

public class Mission {
    private Long id;
    private String type;
    private String location;
    private String riskLevel;
    private String participants;
    private String expectedResources;
    private String status;

    public Mission(Long id, String type, String location, String riskLevel, String participants,
            String expectedResources, String status) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.riskLevel = riskLevel;
        this.participants = participants;
        this.expectedResources = expectedResources;
        this.status = status;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getExpectedResources() {
        return expectedResources;
    }

    public void setExpectedResources(String expectedResources) {
        this.expectedResources = expectedResources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
}
