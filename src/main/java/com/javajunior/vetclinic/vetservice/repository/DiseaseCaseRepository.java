package com.javajunior.vetclinic.vetservice.repository;

import com.javajunior.vetclinic.vetservice.model.DiseaseCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseCaseRepository extends JpaRepository<DiseaseCase, Long> {
}
