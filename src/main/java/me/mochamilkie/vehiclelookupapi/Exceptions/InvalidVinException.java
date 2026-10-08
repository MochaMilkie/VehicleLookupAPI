package me.mochamilkie.vehiclelookupapi.Exceptions;

public class InvalidVinException extends RuntimeException {
    public InvalidVinException(String vin) {
        super(vin + " is not a valid VIN");
    }
}
