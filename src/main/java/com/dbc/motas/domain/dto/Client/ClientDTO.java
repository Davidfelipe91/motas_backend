package com.dbc.motas.domain.dto.Client;

public record ClientDTO(
        Integer id,
        String documentId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address
) {

}
