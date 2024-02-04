package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.Doctor;
import com.javajunior.vetclinic.vetservice.notdto.DiseaseCaseNotDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DiseaseCaseDTO {

    private Doctor doctor;
    private LocalDate date;
    private String caseDescription;

    public DiseaseCaseNotDTO mapToNotDTO(DiseaseCaseDTO diseaseCaseDTO) {
        return DiseaseCaseNotDTO.builder()
                .doctor(diseaseCaseDTO.getDoctor())
                .date(diseaseCaseDTO.getDate())
                .caseDescription(diseaseCaseDTO.getCaseDescription())
                .build();
    }
}
