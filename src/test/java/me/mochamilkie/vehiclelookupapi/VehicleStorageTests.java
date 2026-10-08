package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import me.mochamilkie.vehiclelookupapi.VehicleData.Vehicle;
import me.mochamilkie.vehiclelookupapi.VehicleData.VehicleBuilder;
import me.mochamilkie.vehiclelookupapi.VehicleData.VehicleOverrides;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;

public class VehicleStorageTests {
    VehicleBuilder vehicleBuilder = new VehicleBuilder();
    @Test
    public void buildMockVehicleTest() {
        VIN vin = new VIN("1FTRW12W06KD29937");
        Vehicle expectedVehicle = new Vehicle(vin, Year.of(2006), "FORD", "F150");
        NHTSAResult mockResult = new NHTSAResult(Year.of(2006), "FORD", "F150");
        VehicleOverrides overrides = new VehicleOverrides(Year.of(2020), "Subaru", "Outback");
        Vehicle expectedOverrides = new Vehicle(vin, Year.of(2020), "Subaru", "Outback");
        Assertions.assertEquals(expectedVehicle, vehicleBuilder.buildVehicleFromNHTSA(vin, mockResult));
        Assertions.assertEquals(expectedOverrides, vehicleBuilder.buildVehicleWithOverrides(expectedVehicle, overrides));
    }
}
