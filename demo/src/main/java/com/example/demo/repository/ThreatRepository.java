package com.example.demo.repository;

import com.example.demo.model.Threat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ThreatRepository extends JpaRepository<Threat, Long>, JpaSpecificationExecutor<Threat> {
}
