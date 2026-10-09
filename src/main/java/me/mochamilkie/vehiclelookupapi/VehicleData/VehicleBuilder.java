package me.mochamilkie.vehiclelookupapi.VehicleData;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VinDecoder.NHTSAResult;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VehicleBuilder {
    public Vehicle buildVehicleFromNHTSA(VIN vin, NHTSAResult nr) {
        if(nr.year() == null && Objects.equals(nr.make(), "")) throw new InvalidVinException(vin.vin());
        return new Vehicle(vin, nr.year(), nr.make(), nr.model());
    }
    public Vehicle buildVehicleWithOverrides(Vehicle originalVehicle, VehicleOverrides overrides) {
        return originalVehicle.vehicleWithOverrides(overrides);
    }
}
