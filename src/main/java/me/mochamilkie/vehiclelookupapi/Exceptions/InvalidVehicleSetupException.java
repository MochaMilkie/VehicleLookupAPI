package me.mochamilkie.vehiclelookupapi.Exceptions;

public class InvalidVehicleSetupException extends RuntimeException {
    public InvalidVehicleSetupException() {
        super("Invalid Vehicle Setup, missing VIN");
    }
}
