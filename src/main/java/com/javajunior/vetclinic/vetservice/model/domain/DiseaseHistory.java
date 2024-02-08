package com.javajunior.vetclinic.vetservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javajunior.vetclinic.vetservice.model.dto.DiseaseHistoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "disease_histories")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"name", "breed", "sex", "dateOfBirth", "owner", "diseaseHistory"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    @JsonIgnoreProperties({"doctor", "date", "caseDescription", "diseaseHistory"})
    @OneToMany(mappedBy = "diseaseHistory")
    private List<DiseaseCase> diseaseCases;

    public DiseaseHistoryDTO map(DiseaseHistory diseaseHistory) {
        return DiseaseHistoryDTO.builder()
                .pet(diseaseHistory.getPet())
                .diseaseCases(diseaseHistory.getDiseaseCases())
                .build();
    }
}
