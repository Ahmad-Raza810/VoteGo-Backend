package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.dto.VoterDto;
import com.ahmad.projects.votego.entities.Candidate;
import com.ahmad.projects.votego.entities.Vote;
import com.ahmad.projects.votego.entities.Voter;
import com.ahmad.projects.votego.exception.DuplicateResourceException;
import com.ahmad.projects.votego.exception.ResourceNotFoundException;
import com.ahmad.projects.votego.repository.CandidateRepository;
import com.ahmad.projects.votego.repository.VoterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;


    public VoterServiceImpl(CandidateRepository candidateRepository, VoterRepository voterRepository) {
        this.candidateRepository = candidateRepository;
        this.voterRepository = voterRepository;
    }

    //Service method for register voter
    @Override
    public Voter addVoter(Voter voter) {
        if (voterRepository.existsByEmail(voter.getEmail())) {
            throw new DuplicateResourceException("Voter With email '" + voter.getEmail() + "' already exist.");
        }
        return voterRepository.save(voter);
    }

    //service method for get a voter by id
    @Override
    public Voter getVoterById(Long voterId) {
        return voterRepository.findById(voterId)
                .orElseThrow(() -> new ResourceNotFoundException("Voter With id '" + voterId + "' doesn't exist."));
    }


    //Service method for getting all voter
    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    //Service method for updating voter.
    @Override
    public Voter updateVoter(Voter updatedVoter, Long voterId) {
        Voter voter = voterRepository.findById(voterId).orElseThrow(() -> new ResourceNotFoundException("Voter With id '" + voterId + "' doesn't exist."));
        if (updatedVoter.getEmail() != null)
            voter.setEmail(updatedVoter.getEmail());
        if (updatedVoter.getName() != null)
            voter.setName(updatedVoter.getName());
           return voterRepository.save(voter);

    }


    //Service method for deleting voter.
    @Override
    @Transactional
    public void deleteVoter(Long voterId) {
        Voter voter = voterRepository.findById(voterId).orElseThrow(() -> new ResourceNotFoundException("Voter With id '" + voterId + "' doesn't exist."));
        Vote vote = voter.getVote();
        if (vote != null) {
            Candidate candidate = vote.getCandidate();
            candidate.setVoteCount(candidate.getVoteCount() - 1);
            candidateRepository.save(candidate);
        }
        voterRepository.deleteById(voterId);
    }
}
