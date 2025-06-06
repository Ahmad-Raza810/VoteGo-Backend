package com.ahmad.projects.voting_application.repository;

import com.ahmad.projects.voting_application.entities.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectionResultRepository extends JpaRepository<ElectionResult,Long> {

    Optional<ElectionResult> findByElectionName(String electionName);
}
