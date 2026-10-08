package me.mochamilkie.vehiclelookupapi.VinDecoder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Year;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NHTSAResult(
        @JsonProperty("year") Year year,
        @JsonProperty("make") String make,
        @JsonProperty("model") String model) {
}
