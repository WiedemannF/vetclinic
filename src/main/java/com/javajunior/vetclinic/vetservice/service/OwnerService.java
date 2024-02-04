package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.model.dto.OwnerDTO;
import com.javajunior.vetclinic.vetservice.model.domain.Owner;
import com.javajunior.vetclinic.vetservice.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Transactional
    public Owner create(OwnerDTO owner) {
        return OwnerDTO.map(owner);
    }

    @Transactional(readOnly = true)
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Owner getOwnerById(final Long id) throws NotFoundException {
        return ownerRepository.findById(id).orElseThrow(() -> new NotFoundException("Owner with id " + id + " not found"));
    }

    @Transactional
    public Owner update(final Owner newOwner, Long id) throws NotFoundException {
        Owner existingOwner = getOwnerById(id);
        existingOwner.setName(newOwner.getName());
        existingOwner.setAddress(newOwner.getAddress());
        existingOwner.setPhoneNumber(newOwner.getPhoneNumber());
        existingOwner.setPets(newOwner.getPets());
        return ownerRepository.save(existingOwner);
    }

    @Transactional
    public void delete(final Long id) {
        ownerRepository.deleteById(id);
    }


}
