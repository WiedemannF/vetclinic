package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.dto.DiseaseCaseDTO;
import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.DiseaseCase;
import com.javajunior.vetclinic.vetservice.service.DiseaseCaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/diseaseCases")
@Tag(name = "Случаи заболевания", description = "Контроллер для работы со случаями заболевания в сервисе ветеринарной клиники")
public class DiseaseCaseController {
    private final DiseaseCaseService diseaseCaseService;

    @Operation(description = "Получить однин случай заболевания")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiseaseCase> getDiseaseCase(@RequestParam(value = "diseaseCaseId") Long id) throws NotFoundException {
        DiseaseCase response = diseaseCaseService.getDiseaseCaseById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(description = "Получить все случаи заболевания")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiseaseCase>> getAllDiseaseCases() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(diseaseCaseService.getAllDiseaseCases());
    }

    @Operation(description = "Добавить случай заболевания")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DiseaseCase> createDiseaseCase(@RequestBody DiseaseCaseDTO diseaseCase) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(diseaseCaseService.create(diseaseCase));
    }

    @Operation(description = "Обновить случай заболевания")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DiseaseCase> updateDiseaseCase(@RequestBody DiseaseCase newDiseaseCase,
                                               @RequestParam(value = "diseaseCaseId") Long diseaseCaseId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(diseaseCaseService.update(newDiseaseCase, diseaseCaseId));
    }

    @Operation(description = " Удалить случай заболевания по ID")
    @DeleteMapping(value = "/delete")
    public HttpStatus deleteDiseaseCase(@PathVariable(value = "diseaseCaseId") Long diseaseCaseId) {
        diseaseCaseService.delete(diseaseCaseId);
        return HttpStatus.OK;
    }
}
