package me.mochamilkie.vehiclelookupapi.Lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public record VehicleDetails(@JsonProperty String vin, @JsonProperty String make, @JsonProperty
    String model,@JsonProperty String year,@JsonProperty String fuelType,@JsonProperty String engineSize) {
    public VehicleDetails withOverrides(VehicleDetails o){
                return new VehicleDetails(vin,

                        o.make != null ? o.make : make,
                        o.model != null ? o.model : model,
                        o.year != null ? o.year : year,
                        o.fuelType != null ? o.fuelType :fuelType,
                        o.engineSize != null ? o.engineSize : engineSize);

    }
    public List<String> missingFields() {
        List<String> missing = new ArrayList<>();
        if (engineSize == null) missing.add("engineSize");
        if (year == null) missing.add("year");
        if (fuelType == null) missing.add("fuelType");
        if (model == null) missing.add("model");
        if(make == null) missing.add("make");
        return missing;
    }
}
