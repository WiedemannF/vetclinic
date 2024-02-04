package com.javajunior.vetclinic.vetservice.repository;

import com.javajunior.vetclinic.vetservice.model.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
