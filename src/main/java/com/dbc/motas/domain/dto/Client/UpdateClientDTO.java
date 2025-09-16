package com.dbc.motas.domain.dto.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record UpdateClientDTO(
        @NotNull(message = "DocumentId is obligatory")
        @Positive(message = "DocumentId should be a positive number")
        String documentId,

        @NotBlank(message = "FirstName is obligatory")
        String firstName,

        @NotBlank(message = "LastName is obligatory")
        String lastName,

        @NotBlank(message = "Email is obligatory")
        String email,

        @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "Phone should be a valid number")
        @Positive(message = "Phone number should be a positive number")
        String phoneNumber,

        String address
) {

}
