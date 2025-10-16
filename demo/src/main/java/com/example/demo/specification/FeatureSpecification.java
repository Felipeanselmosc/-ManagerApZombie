package com.example.demo.specification;

import com.example.demo.model.Feature;
import org.springframework.data.jpa.domain.Specification;

public class FeatureSpecification {

    public static Specification<Feature> hasType(String type) {
        return (root, query, cb) ->
                (type == null || type.isBlank()) ? null :
                        cb.like(cb.lower(root.get("type")), "%" + type.toLowerCase() + "%");
    }

    public static Specification<Feature> hasMinQuantity(Integer min) {
        return (root, query, cb) ->
                (min == null) ? null :
                        cb.greaterThanOrEqualTo(root.get("quantity"), min);
    }

    public static Specification<Feature> hasMaxQuantity(Integer max) {
        return (root, query, cb) ->
                (max == null) ? null :
                        cb.lessThanOrEqualTo(root.get("quantity"), max);
    }

    public static Specification<Feature> build(String type, Integer min, Integer max) {
        return Specification.where(hasType(type))
                .and(hasMinQuantity(min))
                .and(hasMaxQuantity(max));
    }
}
