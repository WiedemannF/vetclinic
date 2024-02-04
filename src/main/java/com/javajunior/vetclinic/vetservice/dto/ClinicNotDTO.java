package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.Doctor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClinicNotDTO {

    private String name;
    private String address;
    private List<Doctor> doctors;

    public ClinicDTO mapToDTO(ClinicNotDTO clinicNotDTO) {
        return ClinicDTO.builder()
                .name(clinicNotDTO.getName())
                .address(clinicNotDTO.getAddress())
                .doctors(clinicNotDTO.getDoctors())
                .build();
    }
}
