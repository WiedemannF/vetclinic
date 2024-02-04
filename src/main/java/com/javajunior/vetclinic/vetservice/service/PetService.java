package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.model.dto.PetDTO;
import com.javajunior.vetclinic.vetservice.model.domain.Pet;
import com.javajunior.vetclinic.vetservice.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    @Transactional
    public Pet create(PetDTO pet) {
        return PetDTO.map(pet);
    }

    @Transactional(readOnly = true)
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pet getPetById(final Long id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet with id " + id + " not found"));
    }

    @Transactional
    public Pet update(final Pet newPet, Long id) throws NotFoundException {
        Pet existingPet = getPetById(id);
        existingPet.setName(newPet.getName());
        existingPet.setBreed(newPet.getBreed());
        existingPet.setSex(newPet.getSex());
        existingPet.setDateOfBirth(newPet.getDateOfBirth());
        existingPet.setOwner(newPet.getOwner());
        existingPet.setDiseaseHistory(newPet.getDiseaseHistory());
        return petRepository.save(existingPet);
    }

    @Transactional
    public void delete(final Long id) {
        petRepository.deleteById(id);
    }

}
