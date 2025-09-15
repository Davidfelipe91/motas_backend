package com.dbc.motas.domain.repository;

import com.dbc.motas.domain.dto.Pet.PetDTO;
import com.dbc.motas.domain.dto.Pet.UpdatePetDTO;

import java.util.List;

public interface PetRepository {
    List<PetDTO> getAll();

    PetDTO getById(Integer id);

    PetDTO create(PetDTO petDTO);

    PetDTO update(Integer id, UpdatePetDTO updatePetDTO);

    void delete(Integer id);
}
