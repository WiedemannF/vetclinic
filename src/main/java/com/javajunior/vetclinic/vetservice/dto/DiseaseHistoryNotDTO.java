package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.Doctor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DiseaseHistoryNotDTO {

    private Doctor doctor;
    private LocalDate date;
    private String caseDescription;

    public DiseaseHistoryDTO mapToDTO(DiseaseHistoryNotDTO diseaseHistoryNotDTO) {
        return DiseaseHistoryDTO.builder()
                .doctor(diseaseHistoryNotDTO.getDoctor())
                .date(diseaseHistoryNotDTO.getDate())
                .caseDescription(diseaseHistoryNotDTO.getCaseDescription())
                .build();
    }
}
