package com.ahmad.projects.voting_application.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voterId;

    @NotBlank(message="Name is required.")
    private String name;

    private boolean hasVoted=false;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email should be in valid format.")
    private String email;

    @OneToOne(mappedBy = "voter",cascade = CascadeType.ALL)
    private Vote vote;

}
