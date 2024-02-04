package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.model.dto.PetDTO;
import com.javajunior.vetclinic.vetservice.model.domain.Pet;
import com.javajunior.vetclinic.vetservice.service.PetService;
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
@RequestMapping("/pets")
@Tag(name = "Питомцы", description = "Контроллер для работы с питомцами в сервисе ветеринарной клиники")
public class PetController {
    private final PetService petService;

    @Operation(description = "Получить одного питомца")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> getPet(@RequestParam(value = "petId") Long id) throws NotFoundException {
        Pet response = petService.getPetById(id);
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

    public ResponseEntity<Pet> createPet(@RequestBody PetDTO pet) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(petService.create(pet));
    }

    @Operation(description = "Обновить питомца")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Pet> updatePet(@RequestBody Pet newPet,
                                         @RequestParam(value = "petId") Long petId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(petService.update(newPet, petId));
    }

    @Operation(description = " Удалить питомца по ID")
    @DeleteMapping(value = "/delete")
    public HttpStatus deletePet(@PathVariable(value = "petId") Long petId) {
        petService.delete(petId);
        return HttpStatus.OK;
    }
}
