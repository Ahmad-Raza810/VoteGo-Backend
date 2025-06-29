package com.ahmad.projects.votego.repository;

import com.ahmad.projects.votego.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    List<Candidate> findAllByOrderByVoteCountDesc();

    Optional<Candidate> findByParty(String partyName);
}
