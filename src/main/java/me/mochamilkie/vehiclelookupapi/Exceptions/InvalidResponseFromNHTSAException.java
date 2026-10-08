package me.mochamilkie.vehiclelookupapi.Exceptions;

public class InvalidResponseFromNHTSAException extends RuntimeException {
    public InvalidResponseFromNHTSAException() {
        super("Invalid response from NHTSA, is the API accessible?");
    }
}
