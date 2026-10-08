package me.mochamilkie.vehiclelookupapi.Exceptions;

import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;

public class InvalidVinException extends RuntimeException {
    public InvalidVinException(String vin) {
        super(vin + " is not a valid VIN");
    }
}
