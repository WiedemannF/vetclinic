package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.model.dto.DiseaseHistoryDTO;
import com.javajunior.vetclinic.vetservice.model.domain.DiseaseHistory;
import com.javajunior.vetclinic.vetservice.service.DiseaseHistoryService;
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
@RequestMapping("/diseaseHistories")
@Tag(name = "Истории болезней", description = "Контроллер для работы с историями болезней в сервисе ветеринарной клиники")
public class DiseaseHistoryController {
    private final DiseaseHistoryService diseaseHistoryService;

    @Operation(description = "Получить одну историю болезней")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiseaseHistory> getDiseaseHistory(@RequestParam(value = "diseaseHistoryId") Long id) throws NotFoundException {
        DiseaseHistory response = diseaseHistoryService.getDiseaseHistoryById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(description = "Получить все истории болезней")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiseaseHistory>> getAllDiseaseHistories() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(diseaseHistoryService.getAllDiseaseHistories());
    }

    @Operation(description = "Добавить историю болезней")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DiseaseHistory> createDiseaseHistory(@RequestBody DiseaseHistoryDTO diseaseHistory) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(diseaseHistoryService.create(diseaseHistory));
    }

    @Operation(description = "Обновить историю болезней")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<DiseaseHistory> updateDiseaseHistory(@RequestBody DiseaseHistory newDiseaseHistory,
                                               @RequestParam(value = "diseaseHistoryId") Long diseaseHistoryId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(diseaseHistoryService.update(newDiseaseHistory, diseaseHistoryId));
    }

    @Operation(description = " Удалить историю болезней по ID")
    @DeleteMapping(value = "/delete")
    public HttpStatus deleteDiseaseHistory(@PathVariable(value = "diseaseHistoryId") Long diseaseHistoryId) {
        diseaseHistoryService.delete(diseaseHistoryId);
        return HttpStatus.OK;
    }
}
