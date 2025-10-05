package com.thomazllr.tickets.exception;

public class ModuleNotFoundExceptionException extends EntityNotFoundException {

    public ModuleNotFoundExceptionException(Long id) {
        super("Module with id: '%d' not found.".formatted(id));
    }
}
