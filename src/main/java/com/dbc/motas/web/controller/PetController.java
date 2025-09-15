package com.dbc.motas.web.controller;

import com.dbc.motas.domain.dto.Pet.PetDTO;
import com.dbc.motas.domain.dto.Pet.UpdatePetDTO;
import com.dbc.motas.domain.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping()
    public ResponseEntity<List<PetDTO>> getAll() {
        return ResponseEntity.ok(this.petService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getById(@PathVariable Integer id) {
        PetDTO petDTO = this.petService.getById(id);
        if (petDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(petDTO);
    }

    @PostMapping()
    public ResponseEntity<PetDTO> create(@RequestBody PetDTO petDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.petService.create(petDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PetDTO> update(@PathVariable Integer id, @RequestBody @Valid UpdatePetDTO updatePetDTO) {
        return ResponseEntity.ok(this.petService.update(id, updatePetDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.petService.delete(id);
        return ResponseEntity.ok().build();
    }
}
