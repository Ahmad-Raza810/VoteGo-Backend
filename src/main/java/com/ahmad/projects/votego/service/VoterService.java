package com.ahmad.projects.voting_application.service;

import com.ahmad.projects.voting_application.entities.Voter;

import java.util.List;

public interface VoterService {

    Voter addVoter(Voter voter);

    Voter getVoterById(Long voterId);

    List<Voter> getAllVoters();
    //String deleteVoter(Long voterId);

    /*
     *
     *
     *
     *
     * */
}
