package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.Doctor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DiseaseHistoryDTO {

    private Doctor doctor;
    private LocalDate date;
    private String caseDescription;

    public DiseaseHistoryNotDTO mapToNotDTO(DiseaseHistoryDTO diseaseHistoryDTO) {
        return DiseaseHistoryNotDTO.builder()
                .doctor(diseaseHistoryDTO.getDoctor())
                .date(diseaseHistoryDTO.getDate())
                .caseDescription(diseaseHistoryDTO.getCaseDescription())
                .build();
    }
}
