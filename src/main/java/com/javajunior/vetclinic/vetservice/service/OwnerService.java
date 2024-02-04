package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.Owner;
import com.javajunior.vetclinic.vetservice.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional(readOnly = true)
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Owner getOneOwner(final Long id) throws NotFoundException {
        return ownerRepository.findById(id).orElseThrow(() -> new NotFoundException("Owner with id " + id + " not found"));
    }

    @Transactional
    public void delete(final Long id) {
        ownerRepository.deleteById(id);
    }

    @Transactional
    public Owner create(final Owner newOwner) {
        return ownerRepository.save(newOwner);
    }

    @Transactional
    public Owner update(final Owner newOwner, Long id) throws NotFoundException {
        Owner existingOwner = getOneOwner(id);
        existingOwner.setName(newOwner.getName());
        existingOwner.setAddress(newOwner.getAddress());
        existingOwner.setPhoneNumber(newOwner.getPhoneNumber());
        existingOwner.setPets(newOwner.getPets());

        return ownerRepository.save(existingOwner);
    }
}
