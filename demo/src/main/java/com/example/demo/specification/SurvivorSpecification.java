package com.example.demo.specification;

import com.example.demo.model.Survivor;
import org.springframework.data.jpa.domain.Specification;

public class SurvivorSpecification {

    public static Specification<Survivor> hasName(String name) {
        return (root, query, cb) ->
                (name == null || name.isBlank()) ? null :
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Survivor> hasSkill(String skill) {
        return (root, query, cb) ->
                (skill == null || skill.isBlank()) ? null :
                        cb.like(cb.lower(root.get("skills")), "%" + skill.toLowerCase() + "%");
    }

    public static Specification<Survivor> hasMinHealth(Integer minHealth) {
        return (root, query, cb) ->
                (minHealth == null) ? null :
                        cb.greaterThanOrEqualTo(root.get("health"), minHealth);
    }

    public static Specification<Survivor> hasMaxHealth(Integer maxHealth) {
        return (root, query, cb) ->
                (maxHealth == null) ? null :
                        cb.lessThanOrEqualTo(root.get("health"), maxHealth);
    }

    public static Specification<Survivor> build(String name, String skill, Integer minHealth, Integer maxHealth) {
        return Specification.where(hasName(name))
                .and(hasSkill(skill))
                .and(hasMinHealth(minHealth))
                .and(hasMaxHealth(maxHealth));
    }
}
