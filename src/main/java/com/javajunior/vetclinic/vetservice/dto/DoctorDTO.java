package com.javajunior.vetclinic.vetservice.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDTO {

    private String name;
    private String address;
    private String phoneNumber;

    public DoctorNotDTO mapToNotDTO(DoctorDTO doctorDTO) {
        return DoctorNotDTO.builder()
                .name(doctorDTO.getName())
                .address(doctorDTO.getAddress())
                .phoneNumber(doctorDTO.getPhoneNumber())
                .build();
    }
}
