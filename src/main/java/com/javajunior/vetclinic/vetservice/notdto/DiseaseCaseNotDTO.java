package com.javajunior.vetclinic.vetservice.notdto;

import com.javajunior.vetclinic.vetservice.dto.DiseaseCaseDTO;
import com.javajunior.vetclinic.vetservice.model.Doctor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DiseaseCaseNotDTO {

    private Doctor doctor;
    private LocalDate date;
    private String caseDescription;

    public DiseaseCaseDTO mapToDTO(DiseaseCaseNotDTO diseaseCaseNotDTO) {
        return DiseaseCaseDTO.builder()
                .doctor(diseaseCaseNotDTO.getDoctor())
                .date(diseaseCaseNotDTO.getDate())
                .caseDescription(diseaseCaseNotDTO.getCaseDescription())
                .build();
    }
}
