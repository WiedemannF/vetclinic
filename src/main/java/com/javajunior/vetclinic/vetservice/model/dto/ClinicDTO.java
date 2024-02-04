package com.javajunior.vetclinic.vetservice.model.dto;

import com.javajunior.vetclinic.vetservice.model.domain.Clinic;
import com.javajunior.vetclinic.vetservice.model.domain.Doctor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClinicDTO {

    private String name;
    private String address;
    private List<Doctor> doctors;

    public static Clinic map(ClinicDTO clinicDTO) {
        return Clinic.builder()
                .name(clinicDTO.getName())
                .address(clinicDTO.getAddress())
                .doctors(clinicDTO.getDoctors())
                .build();
    }
}
