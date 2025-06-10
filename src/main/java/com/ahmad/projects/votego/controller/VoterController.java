package com.ahmad.projects.votego.controller;

import com.ahmad.projects.votego.dto.VoterDto;
import com.ahmad.projects.votego.entities.Voter;
import com.ahmad.projects.votego.service.VoterService;
import com.ahmad.projects.votego.service.VoterServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/voter")
public class VoterController {

    @Autowired
    private VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    //Rest endpoint for add a voter
    @PostMapping("/add")
    public ResponseEntity<Voter> addVoter(@Valid @RequestBody Voter voter) {
        Voter returnedVoter = voterService.addVoter(voter);
        return new ResponseEntity<>(returnedVoter, HttpStatus.CREATED);
    }


    //Rest endpoint for add get a voter by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Voter> getVoterById(@PathVariable("id") Long voterId) {
        Voter returnedVoter = voterService.getVoterById(voterId);
        return new ResponseEntity<>(returnedVoter, HttpStatus.OK);
    }

    //Rest endpoint for updating a voter
    @PutMapping("/update/{id}")
    public ResponseEntity<Voter> updateVoter( @RequestBody Voter updatedVoter, @PathVariable("id") Long voterId) {
        Voter returnedVoter = voterService.updateVoter(updatedVoter, voterId);
        return new ResponseEntity<>(returnedVoter, HttpStatus.OK);
    }


    //Rest endpoint for deleting a voter
    @DeleteMapping("/delete/{id}")
    public void deleteVoter(@PathVariable("id") Long voterId) {
        voterService.deleteVoter(voterId);
        //return new ResponseEntity<>(returnedVoter, HttpStatus.OK);
    }

    //Rest endpoint for getting all voters.
    @GetMapping("/get")
    public ResponseEntity<List<Voter>> getAllVoters() {
        List<Voter> voters = voterService.getAllVoters();
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }
}
