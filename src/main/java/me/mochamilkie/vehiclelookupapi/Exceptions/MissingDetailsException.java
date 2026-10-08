package me.mochamilkie.vehiclelookupapi.Exceptions;

public class MissingDetailsException extends RuntimeException {
    public MissingDetailsException() {
        super("Missing details");
    }
}
