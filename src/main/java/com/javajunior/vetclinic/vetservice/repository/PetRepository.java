package com.javajunior.vetclinic.vetservice.repository;

import com.javajunior.vetclinic.vetservice.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
