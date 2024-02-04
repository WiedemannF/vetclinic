package com.javajunior.vetclinic.vetservice.notdto;

import com.javajunior.vetclinic.vetservice.dto.PetDTO;
import com.javajunior.vetclinic.vetservice.model.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.model.Owner;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PetNotDTO {
    private String name;
    private String breed;
    private String sex;
    private LocalDate dateOfBirth;
    private Owner owner;
    private DiseaseHistory diseaseHistory;

    public PetDTO mapToDTO(PetNotDTO petNotDTO) {
        return PetDTO.builder()
                .name(petNotDTO.getName())
                .breed(petNotDTO.getBreed())
                .sex(petNotDTO.getSex())
                .dateOfBirth(petNotDTO.getDateOfBirth())
                .owner(petNotDTO.getOwner())
                .diseaseHistory(petNotDTO.getDiseaseHistory())
                .build();
    }
}
