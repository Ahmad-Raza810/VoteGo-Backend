package com.ahmad.projects.votego.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteRequestDto {

   @NotNull(message = "Voter id is required.")
   private Long voterId;

   @NotNull(message = "Candidate id is required.")
   private Long candidateId;
}
