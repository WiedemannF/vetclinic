package com.javajunior.vetclinic.vetservice.controller;

import com.javajunior.vetclinic.vetservice.exception.NotFoundException;
import com.javajunior.vetclinic.vetservice.model.Owner;
import com.javajunior.vetclinic.vetservice.service.OwnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@Tag(name = "Владельцы", description = "Контроллер для работы с владельцами в сервисе ветеринарной клиники")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Operation(description = "Получить одного владельца")
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Owner> getOwner(@RequestParam(value = "ownerId") Long id) throws NotFoundException {
        Owner response = ownerService.getOneOwner(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @Operation(description = "Получить всех владельцев")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Owner>> getAllOwners() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ownerService.getAllOwners());
    }

    @Operation(description = "Добавить владельца")
    @PostMapping(value = "/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Owner> createOwner(@RequestBody Owner newOwner) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ownerService.create(newOwner));
    }

    @Operation(description = "Обновить владельца")
    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Owner> updateOwner(@RequestBody Owner newOwner,
                                             @RequestParam(value = "ownerId") Long ownerId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ownerService.update(newOwner, ownerId));
    }

    @Operation(description = " Удалить владельца по ID")
    @DeleteMapping(value = "/delete")
    public void deleteOwner(@RequestParam(value = "ownerId") Long ownerId) throws NotFoundException {
        ownerService.delete(ownerId);
    }
}
