package com.ahmad.projects.votego.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private Candidate winner;

    private Integer totalVote;

    @JsonProperty("winnerId")
    public Long getWinnerId(){
        return winner!=null?winner.getCandidateId():null;
    }
}
