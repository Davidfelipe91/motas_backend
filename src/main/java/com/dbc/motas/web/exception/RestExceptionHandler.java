package com.dbc.motas.web.exception;

import com.dbc.motas.domain.enums.Specie;
import com.dbc.motas.domain.exception.SpeciesValueUnacceptedException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SpeciesValueUnacceptedException.class)
    public ResponseEntity<Error> handleException(SpeciesValueUnacceptedException exception) {
        Error error = new Error("species-value-unaccepted", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException exception) {
        List<Error> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleJsonParseError(HttpMessageNotReadableException exception) {
        Throwable cause = exception.getCause();
        if (cause instanceof InvalidFormatException ife) {
            if (ife.getTargetType() != null && ife.getTargetType().equals(Specie.class)) {
                String allowedValues = Arrays.toString(Specie.values());
                Error error = new Error(
                        "species",
                        String.format("Invalid specie '%s'. Allowed values are %s",
                                ife.getValue(), allowedValues)
                );
                return ResponseEntity.badRequest().body(error);
            }
        }
        Error error = new Error("json-parse-error", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception) {
//        exception.printStackTrace();
        Error error = new Error("unknown-error", exception.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
