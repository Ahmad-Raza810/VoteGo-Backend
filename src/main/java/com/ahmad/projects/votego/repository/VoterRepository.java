package com.ahmad.projects.voting_application.repository;

import com.ahmad.projects.voting_application.entities.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VoterRepository extends JpaRepository<Voter,Long> {

    boolean  existByEmail(String Email);

    Optional<List<Voter>> findByName(String name);

}
