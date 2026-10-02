package me.mochamilkie.vehiclelookupapi.Exceptions;

public class VinNotFoundException extends RuntimeException{
    public VinNotFoundException(String vin){
        super("No vehicle found for VIN: " + vin);
    }
}
