package com.example.demo.specification;

import com.example.demo.model.Fortification;
import org.springframework.data.jpa.domain.Specification;

public class FortificationSpecification {

    public static Specification<Fortification> hasType(String type) {
        return (root, query, cb) ->
                (type == null || type.isBlank()) ? null :
                        cb.like(cb.lower(root.get("type")), "%" + type.toLowerCase() + "%");
    }

    public static Specification<Fortification> hasMinIntegrity(Integer min) {
        return (root, query, cb) ->
                (min == null) ? null :
                        cb.greaterThanOrEqualTo(root.get("integrity"), min);
    }

    public static Specification<Fortification> hasMaxIntegrity(Integer max) {
        return (root, query, cb) ->
                (max == null) ? null :
                        cb.lessThanOrEqualTo(root.get("integrity"), max);
    }

    public static Specification<Fortification> build(String type, Integer min, Integer max) {
        return Specification.where(hasType(type))
                .and(hasMinIntegrity(min))
                .and(hasMaxIntegrity(max));
    }
}
