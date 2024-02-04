package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.model.Owner;
import com.javajunior.vetclinic.vetservice.notdto.PetNotDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PetDTO {

    private String name;
    private String breed;
    private String sex;
    private LocalDate dateOfBirth;
    private Owner owner;
    private DiseaseHistory diseaseHistory;

    public PetNotDTO mapToNotDTO(PetDTO petDTO) {
        return PetNotDTO.builder()
                .name(petDTO.getName())
                .breed(petDTO.getBreed())
                .sex(petDTO.getSex())
                .dateOfBirth(petDTO.getDateOfBirth())
                .owner(petDTO.getOwner())
                .diseaseHistory(petDTO.getDiseaseHistory())
                .build();
    }

}
