package com.ahmad.projects.voting_application.repository;

import com.ahmad.projects.voting_application.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {


}
