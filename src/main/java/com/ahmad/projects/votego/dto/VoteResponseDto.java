package com.ahmad.projects.votego.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteResponseDto {
    private Long voterId;
    private Long candidateId;
    private boolean voteResult;
    private String message;

}
