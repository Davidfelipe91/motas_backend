package com.dbc.motas.domain.dto.Pet;

import com.dbc.motas.domain.enums.Specie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdatePetDTO(
        @NotBlank(message = "Name is obligatory")
        String name,

        @NotNull(message = "Age is obligatory")
        @Positive(message = "Age must be a positive number")
        Integer age,

        Specie species,

        String breed
) {

}
