package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.entities.Vote;
import com.ahmad.projects.votego.entities.Candidate;
import com.ahmad.projects.votego.entities.Voter;
import com.ahmad.projects.votego.exception.ResourceNotFoundException;
import com.ahmad.projects.votego.exception.VoteNotAllowedException;
import com.ahmad.projects.votego.repository.CandidateRepository;
import com.ahmad.projects.votego.repository.VoteRepository;
import com.ahmad.projects.votego.repository.VoterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    public VoteServiceImpl(VoterRepository voterRepository, VoteRepository voteRepository, CandidateRepository candidateRepository) {
        this.voterRepository = voterRepository;
        this.voteRepository = voteRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Vote> getAllVote() {
        return voteRepository.findAll();
    }

    @Override
    @Transactional
    public Vote voteCast(Long voterId, Long candidateId) {
        Voter voter=voterRepository.findById(voterId).orElseThrow(()-> new ResourceNotFoundException("Voter with id '"+voterId+"' not exists."));
        Candidate candidate=candidateRepository.findById(candidateId).orElseThrow(()-> new ResourceNotFoundException("Candidate with id '"+candidateId+"' not exists."));

        if (voter.isHasVoted()) {
            throw new VoteNotAllowedException("Voter with id "+voterId+" has already vote casted.");
        }
        Vote vote=new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);

        candidate.setVoteCount(candidate.getVoteCount()+1);
        candidateRepository.save(candidate);

        voter.setVote(vote);
        voter.setHasVoted(true);
        voterRepository.save(voter);
        return vote;
    }

}
