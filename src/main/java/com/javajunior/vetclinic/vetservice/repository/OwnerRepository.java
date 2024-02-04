package com.javajunior.vetclinic.vetservice.repository;

import com.javajunior.vetclinic.vetservice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
