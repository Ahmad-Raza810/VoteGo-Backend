package com.ahmad.projects.votego.dto;

import lombok.Data;

@Data
public class ElectionResultResponseDto {
    private Long winnerId;
    private Integer totalVote;
    private Integer winnerVoteCount;
    private String electionName;



}
