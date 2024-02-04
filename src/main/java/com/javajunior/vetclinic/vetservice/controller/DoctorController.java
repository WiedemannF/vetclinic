package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.model.dto.DoctorDTO;
import com.javajunior.vetclinic.vetservice.model.domain.Doctor;
import com.javajunior.vetclinic.vetservice.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/doctors")
@Tag(name = "Врачи", description = "Контроллер для работы с врачами в сервисе ветеринарной клиники")
public class DoctorController {
    private final DoctorService doctorService;

    @Operation(description = "Получить одного врача")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Doctor> getDoctor(@RequestParam(value = "doctorId") Long id) throws NotFoundException {
        Doctor response = doctorService.getDoctorById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(description = "Получить всех врачей")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctorService.getAllDoctors());
    }

    @Operation(description = "Добавить врача")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDTO doctor) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorService.create(doctor));
    }

    @Operation(description = "Обновить врача")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor newDoctor,
                                         @RequestParam(value = "doctorId") Long doctorId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctorService.update(newDoctor, doctorId));
    }

    @Operation(description = " Удалить врача по ID")
    @DeleteMapping(value = "/delete")
    public HttpStatus deleteDoctor(@PathVariable(value = "doctorId") Long doctorId) {
        doctorService.delete(doctorId);
        return HttpStatus.OK;
    }
}
