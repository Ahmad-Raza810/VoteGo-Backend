package com.ahmad.projects.votego.dto;


import com.ahmad.projects.votego.entities.Voter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoterDto {

    private Integer id;

    @Size(min = 2, message = "Name must contain at least 3 letters.")
    private String name;

    private boolean hasVoted;

    @Email(message = "Email should be in valid format.")
    private String email;



    //voter to dto
    public static VoterDto voterToDto(Voter voter){
        if(voter==null) return null;
        VoterDto voterDto=new VoterDto();
        voter.setVoterId(voter.getVoterId());
        voterDto.setName(voter.getName());
        voterDto.setEmail(voter.getEmail());
        return  voterDto;
    }


    // Dto to Voter
    public static Voter dtoToVoter(VoterDto voterDto){
        if(voterDto==null) return null;
        Voter voter=new Voter();
        voter.setVoterId(voter.getVoterId());
        voter.setName(voterDto.getName());
        voter.setEmail(voterDto.getEmail());
        return  voter;
    }
}
