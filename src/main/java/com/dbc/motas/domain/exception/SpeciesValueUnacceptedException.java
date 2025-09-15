package com.dbc.motas.domain.exception;

public class SpeciesValueUnacceptedException extends RuntimeException {
    public SpeciesValueUnacceptedException(String text){
        super("The value " + text + " is unaccepted");
    }
}
