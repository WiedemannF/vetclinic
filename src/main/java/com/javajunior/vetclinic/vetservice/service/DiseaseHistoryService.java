package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.model.dto.DiseaseHistoryDTO;
import com.javajunior.vetclinic.vetservice.model.domain.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.repository.DiseaseHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class DiseaseHistoryService {
    private final DiseaseHistoryRepository diseaseHistoryRepository;

    @Transactional
    public DiseaseHistory create(DiseaseHistoryDTO diseaseHistory) {
        return DiseaseHistoryDTO.map(diseaseHistory);
    }

    @Transactional(readOnly = true)
    public List<DiseaseHistory> getAllDiseaseHistories() {
        return diseaseHistoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DiseaseHistory getDiseaseHistoryById(final Long id) throws NotFoundException {
        return diseaseHistoryRepository.findById(id).orElseThrow(() -> new NotFoundException("DiseaseHistory with id " + id + " not found"));
    }

    @Transactional
    public DiseaseHistory update(DiseaseHistory newDiseaseHistory, Long id) throws NotFoundException {
        DiseaseHistory existingDiseaseHistory = getDiseaseHistoryById(id);
        existingDiseaseHistory.setPet(newDiseaseHistory.getPet());
        existingDiseaseHistory.setDiseaseCases(newDiseaseHistory.getDiseaseCases());
        return diseaseHistoryRepository.save(existingDiseaseHistory);
    }

    @Transactional
    public void delete(final Long id) {
        diseaseHistoryRepository.deleteById(id);
    }

}
