package com.thomazllr.exception;

public class ForkifySearchException extends RuntimeException {

    public ForkifySearchException(String query) {
        super("No recipes found for '%s'. See phrases at 'http://forkify-api.herokuapp.com/phrases.html'".formatted(query));
    }
}
