package com.javajunior.vetclinic.vetservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "disease_cases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "case_description")
    private String caseDescription;
}
