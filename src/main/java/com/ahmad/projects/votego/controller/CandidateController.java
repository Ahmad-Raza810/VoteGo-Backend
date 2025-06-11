package com.ahmad.projects.votego.controller;

import com.ahmad.projects.votego.entities.Candidate;
import com.ahmad.projects.votego.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/candidate")
public class CandidateController {


        @Autowired
        private CandidateService candidateService;

        public CandidateController(CandidateService candidateService) {
            this.candidateService = candidateService;
        }

        //Rest endpoint for add a candidate
        @PostMapping("/add")
        public ResponseEntity<Candidate> addCandidate(@Valid @RequestBody Candidate candidate) {
            Candidate returnedCandidate = candidateService.addCandidate(candidate);
            return new ResponseEntity<>(returnedCandidate, HttpStatus.CREATED);
        }


        //Rest endpoint for  get a candidate  by id
        @GetMapping("/get/{id}")
        public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long candidateId) {
            Candidate returnedCandidate = candidateService.getCandidateById(candidateId);
            return new ResponseEntity<>(returnedCandidate, HttpStatus.OK);
        }

      //Rest endpoint for updating a Candidate
    @PutMapping("/update/{id}")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate updatedCandidate, @PathVariable("id") Long candidateId) {
        Candidate returnedCandidate = candidateService.updateCandidate(updatedCandidate, candidateId);
            return new ResponseEntity<>(returnedCandidate, HttpStatus.OK);
        }


        //Rest endpoint for deleting a Candidate
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteCandidate(@PathVariable("id") Long candidateId) {
            candidateService.deleteCandidate(candidateId);
            return new ResponseEntity<>("Candidate with id '"+candidateId+"'deleted successfully. ", HttpStatus.OK);
        }

        //Rest endpoint for getting all candidates.
        @GetMapping("/get")
        public ResponseEntity<List<Candidate>> getAllCandidate() {
            List<Candidate> candidates = candidateService.getAllCandidate();
            return new ResponseEntity<>(candidates, HttpStatus.OK);
        }
    }

