package com.javajunior.vetclinic.vetservice.repository;

import com.javajunior.vetclinic.vetservice.model.domain.DiseaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseHistoryRepository extends JpaRepository<DiseaseHistory, Long> {
}
