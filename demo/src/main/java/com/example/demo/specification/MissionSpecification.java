package com.example.demo.specification;

import com.example.demo.model.Mission;
import org.springframework.data.jpa.domain.Specification;

public class MissionSpecification {

    public static Specification<Mission> hasType(String type) {
        return (root, query, cb) ->
                (type == null || type.isBlank()) ? null :
                        cb.like(cb.lower(root.get("type")), "%" + type.toLowerCase() + "%");
    }

    public static Specification<Mission> hasLocation(String location) {
        return (root, query, cb) ->
                (location == null || location.isBlank()) ? null :
                        cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%");
    }

    public static Specification<Mission> hasStatus(String status) {
        return (root, query, cb) ->
                (status == null || status.isBlank()) ? null :
                        cb.equal(cb.lower(root.get("status")), status.toLowerCase());
    }

    public static Specification<Mission> build(String type, String location, String status) {
        return Specification.where(hasType(type))
                .and(hasLocation(location))
                .and(hasStatus(status));
    }
}
