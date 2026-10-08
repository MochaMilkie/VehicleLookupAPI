package me.mochamilkie.vehiclelookupapi.Exceptions;

import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;

public class InvalidVinException extends RuntimeException {
    public InvalidVinException(VIN vin) {
        super(vin.toString().toUpperCase() + " is not a valid VIN");
    }
}
