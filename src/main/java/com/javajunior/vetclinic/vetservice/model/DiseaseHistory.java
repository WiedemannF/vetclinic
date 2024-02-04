package com.javajunior.vetclinic.vetservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "disease_histories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @OneToMany
    @JoinColumn(name = "disease_case_id")
    private List<DiseaseCase> diseaseCases;
}
