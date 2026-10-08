package me.mochamilkie.vehiclelookupapi.VehicleData;

import jakarta.annotation.Nullable;
import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAClient;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Year;

@Service
public class VehicleService {
    private final NHTSAClient nhtsaClient;
    private final VehicleBuilder vehicleBuilder;
    public VehicleService(VehicleBuilder vehicleBuilder, NHTSAClient nhtsaClient) {
        this.vehicleBuilder = vehicleBuilder;
        this.nhtsaClient = nhtsaClient;

    }
    public Vehicle createVehicleFromNHTSA(VIN vin) {
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
