package com.javajunior.vetclinic.vetservice.model.domain;

import com.javajunior.vetclinic.vetservice.model.dto.DoctorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

//    Не успел разобраться со связями, пока вылетает ошибка Could not determine recommended JdbcType for
//    Java type 'com.javajunior.vetclinic.vetservice.model.domain.Doctor'
    @ManyToMany
    @JoinTable(name = "doctor_clinics",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "clinic_id"))
    private List<Clinic> clinics;

    public DoctorDTO map(Doctor doctor) {
        return DoctorDTO.builder()
                .name(doctor.getName())
                .address(doctor.getAddress())
                .phoneNumber(doctor.getPhoneNumber())
                .clinics(doctor.getClinics())
                .build();
    }
}
