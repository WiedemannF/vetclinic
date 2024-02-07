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

    @OneToOne(mappedBy = "diseaseHistory")
    private Pet pet;

    @OneToMany(mappedBy = "diseaseHistory")
    private List<DiseaseCase> diseaseCases;

    public DiseaseHistoryDTO map(DiseaseHistory diseaseHistory) {
        return DiseaseHistoryDTO.builder()
                .pet(diseaseHistory.getPet())
                .diseaseCases(diseaseHistory.getDiseaseCases())
                .build();
    }
}
