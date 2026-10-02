package me.mochamilkie.vehiclelookupapi.Exceptions;

public class VehicleNotInFleetException extends RuntimeException {
    public VehicleNotInFleetException() {
        super("Vehicle Not In Fleet");
    }
}
