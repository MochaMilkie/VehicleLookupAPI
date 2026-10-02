package me.mochamilkie.vehiclelookupapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NhtsaResult(
        @JsonProperty("Make") String make,
        @JsonProperty("Model") String model,
        @JsonProperty("ModelYear") String year,
        @JsonProperty("FuelPrimaryType") String fuelType,
        @JsonProperty("DisplacementL") String engineSize,
        @JsonProperty("ErrorCode") String errorCode){
    
}
