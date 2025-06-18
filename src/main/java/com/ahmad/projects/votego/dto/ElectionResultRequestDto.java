package com.ahmad.projects.votego.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ElectionResultRequestDto{

    @NotBlank(message = "Election name is required.")
    private String electionName;

}
