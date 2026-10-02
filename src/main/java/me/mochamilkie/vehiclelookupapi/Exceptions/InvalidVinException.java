package me.mochamilkie.vehiclelookupapi.Exceptions;

public class InvalidVinException extends RuntimeException{
    public InvalidVinException(String vin){
        super("Invalid VIN: " + vin);
    }
}
