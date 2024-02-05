package com.javajunior.vetclinic.vetservice.model.domain;

import com.javajunior.vetclinic.vetservice.model.dto.OwnerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "owners")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public OwnerDTO map(Owner owner) {
        return OwnerDTO.builder()
                .name(owner.getName())
                .address(owner.getAddress())
                .phoneNumber(owner.getPhoneNumber())
                .pets(owner.getPets())
                .build();
    }
}
