package me.mochamilkie.vehiclelookupapi.Exceptions;

public class VehicleAlreadyInFleetException extends RuntimeException{
    public VehicleAlreadyInFleetException(){
        super("This vehicle is already registered to the fleet.");
    }
}
