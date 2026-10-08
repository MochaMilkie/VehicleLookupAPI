package me.mochamilkie.vehiclelookupapi.VehicleData;

import java.time.Year;

public record VehicleOverrides(
        Year year,
        String make,
        String model) {
}