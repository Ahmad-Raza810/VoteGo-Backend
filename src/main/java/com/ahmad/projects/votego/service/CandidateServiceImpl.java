package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.entities.Candidate;
import com.ahmad.projects.votego.entities.Vote;
import com.ahmad.projects.votego.exception.DuplicateResourceException;
import com.ahmad.projects.votego.exception.ResourceNotFoundException;
import com.ahmad.projects.votego.repository.CandidateRepository;
import com.ahmad.projects.votego.repository.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Candidate addCandidate(Candidate candidate) {
        Candidate returnCandidate=candidateRepository.findByParty(candidate.getParty()).orElse(null);
        if (returnCandidate!=null) {
            throw new DuplicateResourceException("Candidate with party name '"+candidate.getParty()+"' already exists.");
        }
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate getCandidateById(Long candidateId) {
        return candidateRepository
                .findById(candidateId)
                .orElseThrow(()-> new ResourceNotFoundException("Candidate with id '"+candidateId+"' not exists."));
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteCandidate(Long candidateId) {
        Candidate returnedCandidate=getCandidateById(candidateId);
        List<Vote> votes=returnedCandidate.getVote();
        for (Vote vote:votes){
           vote.setCandidate(null);
        }

        returnedCandidate.getVote().clear();
        candidateRepository.delete(returnedCandidate);
    }

    @Override
    public Candidate updateCandidate(Candidate updatedCandidate, Long candidateId) {
        Candidate returnedCandidate=candidateRepository
                .findById(candidateId)
                .orElseThrow(()-> new ResourceNotFoundException("Candidate with id '"+candidateId+"' not exists."));

        if (updatedCandidate.getName()!=null) {
            returnedCandidate.setName(updatedCandidate.getName());
        }
        if (updatedCandidate.getParty()!=null) {
            returnedCandidate.setParty(updatedCandidate.getParty());
        }
        return candidateRepository.save(returnedCandidate);
    }

}
