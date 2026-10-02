package me.mochamilkie.vehiclelookupapi.Exceptions;

public class MissingEngineSizeException extends RuntimeException{
    public MissingEngineSizeException(){
        super("Missing engine size. Please enter the engine size (in liters) then try to add the vehicle to the fleet again.");
    }
}
