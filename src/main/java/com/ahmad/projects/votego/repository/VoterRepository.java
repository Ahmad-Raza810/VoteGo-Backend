package com.ahmad.projects.votego.repository;

import com.ahmad.projects.votego.entities.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VoterRepository extends JpaRepository<Voter,Long> {

    boolean  existsByEmail(String Email);

    Optional<List<Voter>> findByName(String name);

}
