package me.mochamilkie.vehiclelookupapi.VinDecoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Year;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NHTSAResult(
        @JsonProperty("ModelYear") Year year,
        @JsonProperty("Make") String make,
        @JsonProperty("Model") String model) {
}
