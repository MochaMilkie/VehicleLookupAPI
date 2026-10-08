package me.mochamilkie.vehiclelookupapi.VehicleData;

import java.time.Year;

public record Vehicle(
        VIN VIN,
        Year year,
        String make,
        String model) {

}
