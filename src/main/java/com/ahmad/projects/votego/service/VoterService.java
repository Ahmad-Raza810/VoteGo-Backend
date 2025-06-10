package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.dto.VoterDto;
import com.ahmad.projects.votego.entities.Voter;

import java.util.List;

public interface VoterService {

    Voter addVoter(Voter voter);

    Voter getVoterById(Long voterId);

    List<Voter> getAllVoters();

    Voter updateVoter(Voter voter, Long voterId);

    void deleteVoter(Long voterId);

    /*
     *
     *
     *
     *
     * */
}
