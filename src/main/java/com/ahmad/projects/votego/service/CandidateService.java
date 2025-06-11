package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.entities.Candidate;

import java.util.List;

public interface CandidateService {

    Candidate addCandidate(Candidate candidate);

    Candidate getCandidateById(Long candidateId);

    List<Candidate> getAllCandidate();

    void deleteCandidate(Long candidateId);

    Candidate updateCandidate(Candidate updatedCandidate,Long candidateId);

}
