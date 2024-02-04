package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.dto.DiseaseHistoryDTO;
import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.repository.DiseaseHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DiseaseHistoryService {
    private final DiseaseHistoryRepository diseaseHistoryRepository;

    @Transactional
    public DiseaseHistory create(DiseaseHistoryDTO diseaseHistory) {
        return diseaseHistoryRepository.save(DiseaseHistory.builder()
                .pet(diseaseHistory.getPet())
                .diseaseCases(diseaseHistory.getDiseaseCases())
                .build());
    }

    @Transactional(readOnly = true)
    public List<DiseaseHistory> getAllDiseaseHistories() {
        return diseaseHistoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DiseaseHistory getDiseaseHistoryById(final Long id) throws NotFoundException {
        return diseaseHistoryRepository.findById(id).orElseThrow(() -> new NotFoundException("DiseaseHistory with id " + id + " not found"));
    }

//    @Transactional
//    public DiseaseHistory update(DiseaseHistory diseaseHistory) {
//        return diseaseHistoryRepository.save(diseaseHistory);
//    }

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
