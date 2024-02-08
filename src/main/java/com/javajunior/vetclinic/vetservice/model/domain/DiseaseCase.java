package com.javajunior.vetclinic.vetservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javajunior.vetclinic.vetservice.model.dto.DiseaseCaseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "disease_cases")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "case_description")
    private String caseDescription;

    @JsonIgnoreProperties({"pet", "diseaseCases"})
    @ManyToOne
    @JoinColumn(name = "disease_history_id")
    private DiseaseHistory diseaseHistory;

    public DiseaseCaseDTO map(DiseaseCase diseaseCase) {
        return DiseaseCaseDTO.builder()
                .doctor(diseaseCase.getDoctor())
                .date(diseaseCase.getDate())
                .caseDescription(diseaseCase.getCaseDescription())
                .diseaseHistory(diseaseCase.getDiseaseHistory())
                .build();
    }
}
