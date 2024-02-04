package com.javajunior.vetclinic.vetservice.model.dto;

import com.javajunior.vetclinic.vetservice.model.domain.DiseaseCase;
import com.javajunior.vetclinic.vetservice.model.domain.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.model.domain.Pet;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DiseaseHistoryDTO {

    private Pet pet;
    private List<DiseaseCase> diseaseCases;

    public static DiseaseHistory map(DiseaseHistoryDTO diseaseHistoryDTO) {
        return DiseaseHistory.builder()
                .pet(diseaseHistoryDTO.getPet())
                .diseaseCases(diseaseHistoryDTO.getDiseaseCases())
                .build();
    }
}
