package com.ahmad.projects.votego.repository;

import com.ahmad.projects.votego.entities.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectionResultRepository extends JpaRepository<ElectionResult,Long> {

    Optional<ElectionResult> findByElectionName(String electionName);
}
