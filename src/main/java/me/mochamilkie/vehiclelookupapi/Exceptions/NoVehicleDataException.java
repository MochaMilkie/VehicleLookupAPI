package me.mochamilkie.vehiclelookupapi.Exceptions;

public class NoVehicleDataException extends RuntimeException{
    public NoVehicleDataException(){
        super("There is no vehicle data loaded. Please load a vehicle before attempting to add it to your fleet.");
    }
}
