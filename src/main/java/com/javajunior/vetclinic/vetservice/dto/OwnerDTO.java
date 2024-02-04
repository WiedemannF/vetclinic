package com.javajunior.vetclinic.vetservice.dto;

import com.javajunior.vetclinic.vetservice.model.Pet;
import com.javajunior.vetclinic.vetservice.notdto.OwnerNotDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OwnerDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Pet> pets;

    public OwnerNotDTO mapToNotDTO(OwnerDTO ownerDTO) {
        return OwnerNotDTO.builder()
                .name(ownerDTO.getName())
                .address(ownerDTO.getAddress())
                .phoneNumber(ownerDTO.getPhoneNumber())
                .pets(ownerDTO.getPets())
                .build();
    }
}
