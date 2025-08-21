package com.example.demo.model;

public class Survivor {
    private Long id;
    private String name;
    private Integer age;
    private String skills;
    private Integer health;
    private Integer saniti;

    public Survivor(Long id, String name, Integer age, String skills, Integer health, Integer saniti) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skills = skills;
        this.health = health;
        this.saniti = saniti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getSaniti() {
        return saniti;
    }

    public void setSaniti(Integer saniti) {
        this.saniti = saniti;
    }

    
    
    
}
