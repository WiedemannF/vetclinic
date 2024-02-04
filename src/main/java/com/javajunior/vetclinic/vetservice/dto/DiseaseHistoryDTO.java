package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.DiseaseCase;
import com.javajunior.vetclinic.vetservice.model.Doctor;
import com.javajunior.vetclinic.vetservice.model.Pet;
import com.javajunior.vetclinic.vetservice.notdto.DiseaseHistoryNotDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class DiseaseHistoryDTO {

    private Pet pet;
    private List<DiseaseCase> diseaseCases;

    public DiseaseHistoryNotDTO mapToNotDTO(DiseaseHistoryDTO diseaseHistoryDTO) {
        return DiseaseHistoryNotDTO.builder()
                .pet(diseaseHistoryDTO.getPet())
                .diseaseCases(diseaseHistoryDTO.getDiseaseCases())
                .build();
    }
}
