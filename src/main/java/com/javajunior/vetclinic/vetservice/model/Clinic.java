package com.javajunior.vetclinic.vetservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clinics")
@Data
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

    @ManyToMany
    @JoinTable(name = "doctors",
            joinColumns = @JoinColumn(name = "doctor_id"))
    private List<Doctor> doctors;
}
