package me.mochamilkie.vehiclelookupapi.VehicleData;

import jakarta.annotation.Nullable;
import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAClient;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.springframework.web.client.RestClient;

import java.time.Year;

public class VehicleService {
    VehicleBuilder vehicleBuilder;
    public VehicleService() {
        vehicleBuilder = new VehicleBuilder();

    }
    public Vehicle createVehicleFromNHTSA(VIN vin) {
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
