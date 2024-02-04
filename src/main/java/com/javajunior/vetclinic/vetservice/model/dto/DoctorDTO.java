package com.javajunior.vetclinic.vetservice.model.dto;

import com.javajunior.vetclinic.vetservice.model.domain.Clinic;
import com.javajunior.vetclinic.vetservice.model.domain.Doctor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DoctorDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Clinic> clinics;

    public static Doctor map(DoctorDTO doctorDTO) {
        return Doctor.builder()
                .name(doctorDTO.getName())
                .address(doctorDTO.getAddress())
                .phoneNumber(doctorDTO.getPhoneNumber())
                .clinics(doctorDTO.getClinics())
                .build();
    }
}
