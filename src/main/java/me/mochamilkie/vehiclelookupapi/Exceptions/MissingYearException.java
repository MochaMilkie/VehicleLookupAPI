package me.mochamilkie.vehiclelookupapi.Exceptions;

public class MissingYearException extends RuntimeException{
    public MissingYearException(){
        super("Engine year is missing, please add the year of the vehicle before adding to your fleet.");
    }
}
