package com.ahmad.projects.votego.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    @NotBlank(message = "Name is required.")
    private Long name;

    @NotBlank(message = "Party name is required.")
    private String party;

    private Integer voteCount=0;

    @OneToMany(mappedBy="candidate",cascade = CascadeType.ALL)
    private List<Vote> vote;

}
