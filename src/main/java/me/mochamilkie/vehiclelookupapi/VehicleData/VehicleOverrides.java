package me.mochamilkie.vehiclelookupapi.VehicleData;

import java.time.Year;

public record VehicleOverrides(
        VIN VIN,
        Year year,
        String make,
        String model) {
}