package com.javajunior.vetclinic.vetservice.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javajunior.vetclinic.vetservice.model.dto.ClinicDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clinics")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @JsonIgnoreProperties({"name", "address", "phoneNumber"})
    @ManyToMany(mappedBy = "clinics")
    private List<Doctor> doctors;

    public ClinicDTO map(Clinic clinic) {
        return ClinicDTO.builder()
                .name(clinic.getName())
                .address(clinic.getAddress())
                .doctors(clinic.getDoctors())
                .build();
    }
}
