package me.mochamilkie.vehiclelookupapi.VehicleData;

import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.springframework.stereotype.Component;
@Component
public class VehicleBuilder {
    public Vehicle buildVehicleFromNHTSA(VIN vin, NHTSAResult nr) {
        return new Vehicle(vin, nr.year(), nr.make(), nr.model());
    }
    public Vehicle buildVehicleWithOverrides(Vehicle originalVehicle, VehicleOverrides overrides) {
        return originalVehicle.vehicleWithOverrides(overrides);
    }
}
