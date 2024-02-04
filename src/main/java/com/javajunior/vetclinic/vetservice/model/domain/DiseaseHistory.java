package com.javajunior.vetclinic.vetservice.model.domain;

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

    @OneToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @OneToMany
    @JoinColumn(name = "disease_case_id")
    private List<DiseaseCase> diseaseCases;

    public DiseaseHistoryDTO map(DiseaseHistory diseaseHistory) {
        return DiseaseHistoryDTO.builder()
                .pet(diseaseHistory.getPet())
                .diseaseCases(diseaseHistory.getDiseaseCases())
                .build();
    }
}
