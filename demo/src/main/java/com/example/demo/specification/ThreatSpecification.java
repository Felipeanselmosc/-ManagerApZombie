package com.example.demo.specification;

import com.example.demo.model.Threat;
import org.springframework.data.jpa.domain.Specification;

public class ThreatSpecification {

    public static Specification<Threat> hasType(String type) {
        return (root, query, cb) ->
                (type == null || type.isBlank()) ? null :
                        cb.like(cb.lower(root.get("type")), "%" + type.toLowerCase() + "%");
    }

    public static Specification<Threat> hasLocation(String location) {
        return (root, query, cb) ->
                (location == null || location.isBlank()) ? null :
                        cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%");
    }

    public static Specification<Threat> hasMinIntensity(Integer min) {
        return (root, query, cb) ->
                (min == null) ? null :
                        cb.greaterThanOrEqualTo(root.get("intensity"), min);
    }

    public static Specification<Threat> hasMaxIntensity(Integer max) {
        return (root, query, cb) ->
                (max == null) ? null :
                        cb.lessThanOrEqualTo(root.get("intensity"), max);
    }

    public static Specification<Threat> build(String type, String location, Integer min, Integer max) {
        return Specification.where(hasType(type))
                .and(hasLocation(location))
                .and(hasMinIntensity(min))
                .and(hasMaxIntensity(max));
    }
}
