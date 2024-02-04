package com.javajunior.vetclinic.vetservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorNotDTO {

    private String name;
    private String address;
    private String phoneNumber;

    public DoctorDTO mapToDTO(DoctorNotDTO doctorNotDTO) {
        return DoctorDTO.builder()
                .name(doctorNotDTO.getName())
                .address(doctorNotDTO.getAddress())
                .phoneNumber(doctorNotDTO.getPhoneNumber())
                .build();
    }
}
