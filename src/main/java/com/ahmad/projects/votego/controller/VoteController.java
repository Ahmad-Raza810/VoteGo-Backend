package com.ahmad.projects.votego.controller;

import com.ahmad.projects.votego.dto.VoteRequestDto;
import com.ahmad.projects.votego.dto.VoteResponseDto;
import com.ahmad.projects.votego.entities.Vote;
import com.ahmad.projects.votego.entities.Voter;
import com.ahmad.projects.votego.service.VoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;


    //Rest endpoint for casting a vote.
    @PostMapping("/cast")
    public ResponseEntity<VoteResponseDto> castVote(@Valid @RequestBody VoteRequestDto voteRequestDto) {
        Vote vote=voteService.voteCast(voteRequestDto.getVoterId(),voteRequestDto.getCandidateId());
        VoteResponseDto voteResponseDto=new VoteResponseDto(vote.getVoterId(),vote.getCandidateId(),true,"Vote successfully casted.");
        return new ResponseEntity<>(voteResponseDto, HttpStatus.OK);
    }

    //Rest endpoint for getting all voters.
    @GetMapping("/get")
    public ResponseEntity<List<Vote>> getAllVote() {
        List<Vote> votes = voteService.getAllVote();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }
}
