package com.ahmad.projects.votego.controller;

import com.ahmad.projects.votego.dto.ElectionResultRequestDto;
import com.ahmad.projects.votego.dto.ElectionResultResponseDto;
import com.ahmad.projects.votego.entities.ElectionResult;
import com.ahmad.projects.votego.entities.Voter;
import com.ahmad.projects.votego.service.ElectionResultServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/er")
public class ElectionResultController {

    @Autowired
    private ElectionResultServiceImpl electionResultService;

    //Rest endpoint for getting result of a election
    @PostMapping("/dr")
    public ResponseEntity<ElectionResultResponseDto> declareResult(@Valid  @RequestBody ElectionResultRequestDto electionResultRequestDto) {
        ElectionResult electionResult=electionResultService.declareElectionResult(electionResultRequestDto.getElectionName());


        ElectionResultResponseDto electionResultResponseDto=new ElectionResultResponseDto();
        electionResultResponseDto.setElectionName(electionResult.getElectionName());
        electionResultResponseDto.setWinnerId(electionResult.getWinnerId());
        electionResultResponseDto.setWinnerVoteCount(electionResult.getWinner().getVoteCount());
        electionResultResponseDto.setTotalVote(electionResult.getTotalVote());
        return new ResponseEntity<>(electionResultResponseDto, HttpStatus.OK);
    }

     //Rest endpoint for getting all election result.
     @GetMapping("/get")
      public ResponseEntity<List<ElectionResult>> getAllVoters() {
        List<ElectionResult> electionResults = electionResultService.getAllElectionResult();
        return new ResponseEntity<>(electionResults, HttpStatus.OK);
    }

}
