package com.javajunior.vetclinic.vetservice.notdto;

import com.javajunior.vetclinic.vetservice.dto.DiseaseHistoryDTO;
import com.javajunior.vetclinic.vetservice.model.DiseaseCase;
import com.javajunior.vetclinic.vetservice.model.Doctor;
import com.javajunior.vetclinic.vetservice.model.Pet;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class DiseaseHistoryNotDTO {

    private Pet pet;
    private List<DiseaseCase> diseaseCases;

    public DiseaseHistoryDTO mapToDTO(DiseaseHistoryNotDTO diseaseHistoryNotDTO) {
        return DiseaseHistoryDTO.builder()
                .pet(diseaseHistoryNotDTO.getPet())
                .diseaseCases(diseaseHistoryNotDTO.getDiseaseCases())
                .build();
    }
}
