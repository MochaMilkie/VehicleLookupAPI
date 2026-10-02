package me.mochamilkie.vehiclelookupapi.Lookup;

import java.util.ArrayList;
import java.util.List;

public record VehicleDetails(String vin, String make, String model, String year, String fuelType, String engineSize) {
    public VehicleDetails withOverrides(VehicleDetails o){
                return new VehicleDetails(vin,

                        o.make != null ? o.make : make,
                        o.model != null ? o.make : make,
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
