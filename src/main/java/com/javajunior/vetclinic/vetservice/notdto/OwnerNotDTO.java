package com.javajunior.vetclinic.vetservice.notdto;

import com.javajunior.vetclinic.vetservice.dto.OwnerDTO;
import com.javajunior.vetclinic.vetservice.model.Pet;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OwnerNotDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Pet> pets;

    public OwnerDTO mapToDTO(OwnerNotDTO ownerNotDTO) {
        return OwnerDTO.builder()
                .name(ownerNotDTO.getName())
                .address(ownerNotDTO.getAddress())
                .phoneNumber(ownerNotDTO.getPhoneNumber())
                .pets(ownerNotDTO.getPets())
                .build();
    }
}
