package com.ahmad.projects.votego.repository;

import com.ahmad.projects.votego.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {


}
