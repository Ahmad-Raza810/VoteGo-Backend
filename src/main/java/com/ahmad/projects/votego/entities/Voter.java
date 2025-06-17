package com.ahmad.projects.votego.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voterId;

    @NotBlank(message = "Name is required.")
    private String name;

    private boolean hasVoted = false;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email should be in valid format.")
    private String email;

    @OneToOne(mappedBy = "voter", cascade = CascadeType.ALL)
    @JsonIgnore
    private Vote vote;

}
