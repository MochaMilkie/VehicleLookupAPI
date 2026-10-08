package me.mochamilkie.vehiclelookupapi;

import jakarta.annotation.Nullable;
import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import me.mochamilkie.vehiclelookupapi.VehicleData.Vehicle;
import me.mochamilkie.vehiclelookupapi.VehicleData.VehicleBuilder;
import me.mochamilkie.vehiclelookupapi.VehicleData.VehicleOverrides;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAClient;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.springframework.web.client.RestClient;

import java.time.Year;

public class VehicleController {
    VehicleBuilder vehicleBuilder;
    public VehicleController() {

    }
    public Vehicle createVehicleFromNHTSA(VIN vin) {
        if(!vin.validateVIN()) throw new InvalidVinException(vin);
        NHTSAClient nhtsaClient = new NHTSAClient(RestClient.builder());
        NHTSAResult nhtsaResult = nhtsaClient.decodeVin(vin);
        return vehicleBuilder.buildVehicleFromNHTSA(vin, nhtsaResult);
    }
    public Vehicle createVehicleWithOverrides(Vehicle vehicle, VehicleOverrides overrides) {
        return vehicleBuilder.buildVehicleWithOverrides(vehicle, overrides);
    }
    public VehicleOverrides createVehicleOverrides(@Nullable Year year,@Nullable String make,@Nullable String model) {
        return new VehicleOverrides(year, make, model);
    }

}
