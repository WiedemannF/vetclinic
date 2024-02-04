package com.javajunior.vetclinic.vetservice.model.dto;

import com.javajunior.vetclinic.vetservice.model.domain.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.model.domain.Owner;
import com.javajunior.vetclinic.vetservice.model.domain.Pet;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PetDTO {

    private String name;
    private String breed;
    private String sex;
    private LocalDate dateOfBirth;
    private Owner owner;
    private DiseaseHistory diseaseHistory;

    public static Pet map(PetDTO petDTO) {
        return Pet.builder()
                .name(petDTO.getName())
                .breed(petDTO.getBreed())
                .sex(petDTO.getSex())
                .dateOfBirth(petDTO.getDateOfBirth())
                .owner(petDTO.getOwner())
                .diseaseHistory(petDTO.getDiseaseHistory())
                .build();
    }

}
