package com.javajunior.vetclinic.vetservice.model.dto;

import com.javajunior.vetclinic.vetservice.model.domain.DiseaseCase;
import com.javajunior.vetclinic.vetservice.model.domain.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.model.domain.Doctor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DiseaseCaseDTO {

    private Doctor doctor;
    private LocalDate date;
    private String caseDescription;
    private DiseaseHistory diseaseHistory;

    public static DiseaseCase map(DiseaseCaseDTO diseaseCaseDTO) {
        return DiseaseCase.builder()
                .doctor(diseaseCaseDTO.getDoctor())
                .date(diseaseCaseDTO.getDate())
                .caseDescription(diseaseCaseDTO.getCaseDescription())
                .diseaseHistory(diseaseCaseDTO.getDiseaseHistory())
                .build();
    }
}
