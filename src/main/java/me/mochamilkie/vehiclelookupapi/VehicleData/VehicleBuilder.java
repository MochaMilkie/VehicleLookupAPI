package me.mochamilkie.vehiclelookupapi.VehicleData;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAClient;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.springframework.web.client.RestClient;

public class VehicleBuilder {
    private final NHTSAClient nhtsaClient;

    public VehicleBuilder(NHTSAClient nhtsaClient) {
       this.nhtsaClient = new NHTSAClient(RestClient.builder());
    }
    public Vehicle buildVehicleFromNHTSA(VIN vin, NHTSAResult nr) {
        if(!vin.validateVIN()) throw new InvalidVinException(vin);
        return new Vehicle(vin, nr.year(), nr.make(), nr.model());
    }
    public Vehicle buildVehicleWithOverrides(Vehicle originalVehicle, VehicleOverrides overrides) {
        return originalVehicle.vechileWithOverrides(overrides);
    }
}
