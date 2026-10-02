package me.mochamilkie.vehiclelookupapi.Fleet;

import me.mochamilkie.vehiclelookupapi.Exceptions.MissingEngineSizeException;
import me.mochamilkie.vehiclelookupapi.Exceptions.MissingYearException;
import me.mochamilkie.vehiclelookupapi.Exceptions.NoVehicleDataException;
import me.mochamilkie.vehiclelookupapi.Exceptions.VehicleAlreadyInFleetException;
import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;

import java.util.HashMap;
import java.util.Map;

public class FleetStorage {
    Map<String, VehicleDetails> storage = new HashMap();
    public FleetStorage(){

    }
    public void addVehicleToFleet(String vin, VehicleDetails vehicleDetails){
        //Figure out how to take user input and apply it to the overrides.
        VehicleDetails manual = new VehicleDetails(null, null, null,null,null,null);

        VehicleDetails complete = vehicleDetails.withOverrides(manual);
        storage.putIfAbsent(vin, complete);
    }
}
