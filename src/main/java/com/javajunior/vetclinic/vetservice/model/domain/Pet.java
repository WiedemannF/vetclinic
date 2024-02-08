package com.javajunior.vetclinic.vetservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javajunior.vetclinic.vetservice.model.dto.PetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @JsonIgnoreProperties({"name", "address", "phoneNumber", "pets"})
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @JsonIgnoreProperties({"pet", "diseaseCases"})
    @OneToOne(mappedBy = "pet")
    private DiseaseHistory diseaseHistory;

    public PetDTO map(Pet pet) {
        return PetDTO.builder()
                .name(pet.getName())
                .breed(pet.getBreed())
                .sex(pet.getSex())
                .dateOfBirth(pet.getDateOfBirth())
                .owner(pet.getOwner())
                .diseaseHistory(pet.getDiseaseHistory())
                .build();
    }
}
