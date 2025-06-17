package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.entities.Vote;

import java.util.List;

public interface VoteService {

    List<Vote> getAllVote();

    Vote voteCast(Long voterId,Long candidateId);
}
