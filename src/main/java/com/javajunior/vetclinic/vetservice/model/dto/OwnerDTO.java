package com.javajunior.vetclinic.vetservice.model.dto;

import com.javajunior.vetclinic.vetservice.model.domain.Owner;
import com.javajunior.vetclinic.vetservice.model.domain.Pet;
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

    public static Owner map(OwnerDTO ownerDTO) {
        return Owner.builder()
                .name(ownerDTO.getName())
                .address(ownerDTO.getAddress())
                .phoneNumber(ownerDTO.getPhoneNumber())
                .pets(ownerDTO.getPets())
                .build();
    }
}
