package me.mochamilkie.vehiclelookupapi.VehicleData;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;

public record VIN(String vin) {
    public VIN{
        if (vin == null || !vin.matches("^[A-HJ-NPR-Z0-9]{17}$"))
            throw new InvalidVinException(this);
    }
}
