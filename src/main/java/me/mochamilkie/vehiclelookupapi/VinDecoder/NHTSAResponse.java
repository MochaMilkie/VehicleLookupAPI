package me.mochamilkie.vehiclelookupapi.VinDecoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.mochamilkie.vehiclelookupapi.VehicleData.Vehicle;

import java.time.Year;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NHTSAResponse(
        @JsonProperty("year") Year year,
        @JsonProperty("make") String make,
        @JsonProperty("model") String model) {
}
