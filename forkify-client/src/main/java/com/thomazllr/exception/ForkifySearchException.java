package com.thomazllr.exception;

public class ForkifySearchException extends RuntimeException {

    public ForkifySearchException(String message) {
        super("No recipes found for '%s'. See phrases at 'http://forkify-api.herokuapp.com/phrases.html'".formatted(message));
    }
}
