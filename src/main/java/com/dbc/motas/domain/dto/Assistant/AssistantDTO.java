package com.dbc.motas.domain.dto.Assistant;

public record AssistantDTO(
        Integer id,
        String documentId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address
) {
}
