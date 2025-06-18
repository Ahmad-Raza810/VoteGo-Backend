package com.ahmad.projects.votego.service;

import com.ahmad.projects.votego.entities.Candidate;
import com.ahmad.projects.votego.entities.ElectionResult;
import com.ahmad.projects.votego.exception.ResourceNotFoundException;
import com.ahmad.projects.votego.repository.CandidateRepository;
import com.ahmad.projects.votego.repository.ElectionResultRepository;
import com.ahmad.projects.votego.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionResultServiceImpl {

    @Autowired
    private ElectionResultRepository electionResultRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VoteRepository voteRepository;

    public ElectionResult declareElectionResult(String electionName) {

        // Check if result already exists
        return electionResultRepository.findByElectionName(electionName)
                .orElseGet(() -> {
                    // If no votes yet
                    if (voteRepository.count() == 0) {
                        throw new IllegalStateException("As votes are not casted, there is no election result.");
                    }

                    // Get all candidates sorted by vote count
                    List<Candidate> candidates = candidateRepository.findAllByOrderByVoteCountDesc();

                    if (candidates.isEmpty()) {
                        throw new ResourceNotFoundException("Candidates are not available.");
                    }

                    // Calculate total votes
                    int totalVoteCount = candidates.stream()
                            .mapToInt(Candidate::getVoteCount)
                            .sum();

                    // First candidate is the winner
                    Candidate winner = candidates.get(0);

                    // Create and save new ElectionResult
                    ElectionResult newResult = new ElectionResult();
                    newResult.setElectionName(electionName);
                    newResult.setWinner(winner);
                    newResult.setTotalVote(totalVoteCount);


                    return electionResultRepository.save(newResult);
                });
    }

    public List<ElectionResult> getAllElectionResult() {
        return electionResultRepository.findAll();
    }
}
