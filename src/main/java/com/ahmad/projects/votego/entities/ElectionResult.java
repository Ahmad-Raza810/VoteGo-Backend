package com.ahmad.projects.voting_application.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class ElectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  electionId;

    @NotBlank(message = "Election name is required.")
    private String electionName;

    @OneToOne
    @JoinColumn(name = "winner_id")
    private Candidate winner;

    private Integer totalVote;
}
