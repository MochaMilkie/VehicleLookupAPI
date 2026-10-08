package me.mochamilkie.vehiclelookupapi.VehicleData;

public record VIN(String vin) {
    public boolean validateVIN() {
        return vin.matches("^[A-HJ-NPR-Z0-9]{17}$");
        //regex is hard still, needed help here
    }
}
