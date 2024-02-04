package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.dto.ClinicDTO;
import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.Clinic;
import com.javajunior.vetclinic.vetservice.repository.ClinicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClinicService {
    private final ClinicRepository clinicRepository;

    @Transactional
    public Clinic create(ClinicDTO clinic) {
        return clinicRepository.save(Clinic.builder()
                .name(clinic.getName())
                .address(clinic.getAddress())
                .doctors(clinic.getDoctors())
                .build());
    }

    @Transactional(readOnly = true)
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Clinic getClinicById(final Long id) throws NotFoundException {
        return clinicRepository.findById(id).orElseThrow(() -> new NotFoundException("Clinic with id " + id + " not found"));
    }

//    @Transactional
//    public Clinic update(Clinic clinic) {
//        return clinicRepository.save(clinic);
//    }

    @Transactional
    public Clinic update(Clinic newClinic, Long id) throws NotFoundException {
        Clinic existingClinic = getClinicById(id);
        existingClinic.setName(newClinic.getName());
        existingClinic.setAddress(newClinic.getAddress());
        existingClinic.setDoctors(newClinic.getDoctors());
        return clinicRepository.save(existingClinic);
    }

    @Transactional
    public void delete(final Long id) {
        clinicRepository.deleteById(id);
    }
}
