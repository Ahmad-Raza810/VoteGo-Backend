package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.entities.Vote;

public interface VoteService {

    Vote addVote(Vote vote);

    void deleteVote(Long voteId);


}
