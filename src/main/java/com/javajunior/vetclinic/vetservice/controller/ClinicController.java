package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.model.domain.Clinic;
import com.javajunior.vetclinic.vetservice.model.dto.ClinicDTO;
import com.javajunior.vetclinic.vetservice.service.ClinicService;
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
@RequestMapping("/clinics")
@Tag(name = "Клиники", description = "Контроллер для работы с клиниками в сервисе ветеринарной клиники")
public class ClinicController {
    private final ClinicService clinicService;

    @Operation(description = "Получить одну клинику")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clinic> getClinic(@RequestParam(value = "clinicId") Long id) throws NotFoundException {
        Clinic response = clinicService.getClinicById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(description = "Получить все клиники")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clinicService.getAllClinics());
    }

    @Operation(description = "Добавить клинику")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Clinic> createClinic(@RequestBody ClinicDTO clinic) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clinicService.create(clinic));
    }

    @Operation(description = "Обновить клинику")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Clinic> updateClinic(@RequestBody Clinic newClinic,
                                               @RequestParam(value = "clinicId") Long clinicId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clinicService.update(newClinic, clinicId));
    }

    @Operation(description = " Удалить клинику по ID")
    @DeleteMapping(value = "/delete")
    public HttpStatus deleteClinic(@PathVariable(value = "clinicId") Long clinicId) {
        clinicService.delete(clinicId);
        return HttpStatus.OK;
    }
}
