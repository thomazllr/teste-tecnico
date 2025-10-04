package com.thomazllr.tickets.exception;

public class InvalidModuleInputException extends InvalidInputException {

    public InvalidModuleInputException(Long id) {
        super("Cannot create ticket: module '%d' is invalid or does not exist.".formatted(id));
    }
}