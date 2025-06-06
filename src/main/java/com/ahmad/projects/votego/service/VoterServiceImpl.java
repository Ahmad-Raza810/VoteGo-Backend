package com.ahmad.projects.voting_application.service;

import com.ahmad.projects.voting_application.entities.Voter;
import com.ahmad.projects.voting_application.exception.DuplicateResourceException;
import com.ahmad.projects.voting_application.exception.ResourceNotFoundException;
import com.ahmad.projects.voting_application.repository.CandidateRepository;
import com.ahmad.projects.voting_application.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService{

    @Autowired
    private  VoterRepository voterRepository;
    @Autowired
    private  CandidateRepository candidateRepository;



    public VoterServiceImpl(CandidateRepository candidateRepository, VoterRepository voterRepository) {
        this.candidateRepository = candidateRepository;
        this.voterRepository = voterRepository;
    }

    //Service method for register voter
    @Override
    public Voter addVoter(Voter voter) {
        if(voterRepository.existByEmail(voter.getEmail())){
            throw new DuplicateResourceException("Voter With email '"+voter.getEmail()+"' already exist.");
        }
        return voterRepository.save(voter);
    }

    //service method for get an voter by id
    @Override
    public Voter getVoterById(Long voterId) {
         return voterRepository.findById(voterId)
                 .orElseThrow(()->new ResourceNotFoundException("Voter With id '"+voterId+"' doesn't exist."));
    }


    //Service method for getting all voter
    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }




 //   @Override
//    public List<Voter> getVoterByName(String voterName) {
//        List<Voter> voters=voterRepository.findByName(voterName).orElseThrow(()->new ResourceNotFoundException("Voter With name '"+voterName+"' doesn't exist."));
//        return voters;
//    }



//    @Override
//    public String deleteVoter(Long voterId) {
//        Voter voter=voterRepository.findById(voterId).orElseThrow(()-> new ResourceNotFoundException("Voter with id '"+voterId+"' not exist."));
//        if(voter.isHasVoted())
//        {
//       voter.getVote().getCandidate().setVoteCount(-1);
//        }
//        voterRepository.deleteById(voterId);
//        return "Voter delete successfully.";
//    }

}
