package com.javajunior.vetclinic.vetservice.service;

import com.javajunior.vetclinic.vetservice.model.dto.DoctorDTO;
import com.javajunior.vetclinic.vetservice.model.domain.Doctor;
import com.javajunior.vetclinic.vetservice.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Transactional
    public Doctor create(DoctorDTO doctor) {
        return DoctorDTO.map(doctor);
    }

    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Doctor getDoctorById(final Long id) throws NotFoundException {
        return doctorRepository.findById(id).orElseThrow(() -> new NotFoundException("Doctor with id " + id + " not found"));
    }

    @Transactional
    public Doctor update(Doctor newDoctor, Long id) throws NotFoundException {
        Doctor existingDoctor = getDoctorById(id);
        existingDoctor.setName(newDoctor.getName());
        existingDoctor.setAddress(newDoctor.getAddress());
        existingDoctor.setPhoneNumber(newDoctor.getPhoneNumber());
        return doctorRepository.save(existingDoctor);
    }

    @Transactional
    public void delete(final Long id) {
        doctorRepository.deleteById(id);
    }
}
