package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.Doctor;
import com.javajunior.vetclinic.vetservice.notdto.ClinicNotDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClinicDTO {

    private String name;
    private String address;
    private List<Doctor> doctors;

    public ClinicNotDTO mapToNotDTO(ClinicDTO clinicDTO) {
        return ClinicNotDTO.builder()
                .name(clinicDTO.getName())
                .address(clinicDTO.getAddress())
                .doctors(clinicDTO.getDoctors())
                .build();
    }
}
