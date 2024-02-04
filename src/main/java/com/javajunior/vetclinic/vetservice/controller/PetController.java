package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.Pet;
import com.javajunior.vetclinic.vetservice.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@Tag(name = "Питомцы", description = "Контроллер для работы с питомцами в сервисе ветеринарной клиники")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @Operation(description = "Получить одного питомца")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> getPet(@RequestParam(value = "petId") Long id) throws NotFoundException {
        Pet response = petService.getOnePet(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(description = "Получить всех питомцев")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(petService.getAllPets());
    }

    @Operation(description = "Добавить питомца")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Pet> createPet(@RequestBody Pet newPet) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petService.create(newPet));
    }

    @Operation(description = "Обновить питомца")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Pet> updatePet(@RequestBody Pet newPet,
                                         @RequestParam(value = "petId") Long petId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petService.update(newPet, petId));
    }

    @Operation(description = " Удалить питомца по ID")
    @DeleteMapping(value = "/delete")
    public void deletePet(@RequestParam(value = "petId") Long petId) throws NotFoundException {
        petService.delete(petId);
    }
}
