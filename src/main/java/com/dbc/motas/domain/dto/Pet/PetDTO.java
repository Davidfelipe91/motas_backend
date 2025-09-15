package com.dbc.motas.domain.dto.Pet;

import com.dbc.motas.domain.enums.Specie;

public record PetDTO(
        Integer id,
        String name,
        Integer age,
        Specie species,
        String breed
) {

}
