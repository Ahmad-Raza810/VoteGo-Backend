package com.ahmad.projects.votego.entities;


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
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
