package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.model.dto.DiseaseCaseDTO;
import com.javajunior.vetclinic.vetservice.model.domain.DiseaseCase;
import com.javajunior.vetclinic.vetservice.repository.DiseaseCaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class DiseaseCaseService {
    private final DiseaseCaseRepository diseaseCaseRepository;

    @Transactional
    public DiseaseCase create(DiseaseCaseDTO diseaseCase) {
        return DiseaseCaseDTO.map(diseaseCase);
    }

    @Transactional(readOnly = true)
    public List<DiseaseCase> getAllDiseaseCases() {
        return diseaseCaseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DiseaseCase getDiseaseCaseById(final Long id) throws NotFoundException {
        return diseaseCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("DiseaseCase with id " + id + " not found"));
    }

    @Transactional
    public DiseaseCase update(DiseaseCase newDiseaseCase, Long id) throws NotFoundException {
        DiseaseCase existingDiseaseCase = getDiseaseCaseById(id);
        existingDiseaseCase.setDoctor(newDiseaseCase.getDoctor());
        existingDiseaseCase.setDate(newDiseaseCase.getDate());
        existingDiseaseCase.setCaseDescription(newDiseaseCase.getCaseDescription());
        return diseaseCaseRepository.save(existingDiseaseCase);
    }

    @Transactional
    public void delete(final Long id) {
        diseaseCaseRepository.deleteById(id);
    }

}
