package com.ahmad.projects.votego.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    @OneToOne
    @JoinColumn(name = "voter_id", unique = true)
    @JsonIgnore
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @JsonIgnore
    private Candidate candidate;

    @JsonProperty("voterId")
    public Long getVoterId(){
        return voter!=null?voter.getVoterId():null;
    }

    @JsonProperty("candidateId")
    public Long getCandidateId(){
        return candidate!=null?candidate.getCandidateId():null;
    }
}
