package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.Pet;
import com.javajunior.vetclinic.vetservice.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional(readOnly = true)
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pet getOnePet(final Long id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet with id " + id + " not found"));
    }

    @Transactional
    public void delete(final Long id) {
        petRepository.deleteById(id);
    }

    @Transactional
    public Pet create(final Pet newPet) {
        return petRepository.save(newPet);
    }

    @Transactional
    public Pet update(final Pet newPet, Long id) throws NotFoundException {
        Pet existingPet = getOnePet(id);
        existingPet.setName(newPet.getName());
        existingPet.setBreed(newPet.getBreed());
        existingPet.setSex(newPet.getSex());
        existingPet.setDateOfBirth(newPet.getDateOfBirth());
        existingPet.setOwner(newPet.getOwner());
        existingPet.setDiseaseHistory(newPet.getDiseaseHistory());

        return petRepository.save(existingPet);
    }

}
