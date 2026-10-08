package me.mochamilkie.vehiclelookupapi.VehicleData;

import java.time.Year;

public record Vehicle(
        VIN VIN,
        Year year,
        String make,
        String model) {
    public Vehicle vehicleWithOverrides(VehicleOverrides o) {

        return new Vehicle(
                VIN,
                o.year() != null ? o.year() : year,
                o.make() != null ? o.make() : make,
                o.model() != null ? o.model() : model);

    }
}
