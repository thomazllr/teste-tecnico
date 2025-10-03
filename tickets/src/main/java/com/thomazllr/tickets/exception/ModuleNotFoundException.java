package com.thomazllr.tickets.exception;

public class ModuleNotFoundException extends EntityNotFound {

    public ModuleNotFoundException(Long id) {
        super("Module with id: '%d' not found.".formatted(id));
    }
}
