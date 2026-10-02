package me.mochamilkie.vehiclelookupapi;

public record VehicleDetails(String vin, String make, String model, int year, String fuelType, String engineSize) {
    public int getYear() {
        return year;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getFuelType() {
        return fuelType;
    }
    public String getEngine() {
        return engineSize;
    }
}
