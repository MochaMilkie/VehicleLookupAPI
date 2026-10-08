package me.mochamilkie.vehiclelookupapi.VinDecoder;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.mochamilkie.vehiclelookupapi.VehicleData.Vehicle;

import java.time.Year;

public record NHTSAResponse(
        @JsonProperty String vin,
        @JsonProperty Year year,
        @JsonProperty String make,
        @JsonProperty String model) {
}
