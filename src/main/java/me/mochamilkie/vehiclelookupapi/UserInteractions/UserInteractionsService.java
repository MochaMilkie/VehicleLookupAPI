package me.mochamilkie.vehiclelookupapi.UserInteractions;

import me.mochamilkie.vehiclelookupapi.Exceptions.VehicleAlreadyInFleetException;
import me.mochamilkie.vehiclelookupapi.Exceptions.VehicleNotInFleetException;
import me.mochamilkie.vehiclelookupapi.Fleet.FleetStorage;
import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;
import me.mochamilkie.vehiclelookupapi.Lookup.VinDecoder;
import org.springframework.web.client.RestClient;

import java.util.Map;

public class UserInteractionsService {
    private final FleetStorage fleetStorage;

    public UserInteractionsService(FleetStorage fleetStorage) {
        this.fleetStorage = fleetStorage;
    }

    public VehicleDetails decodeVin(String vin) {
        VinDecoder decoder = new VinDecoder(RestClient.builder());
        decoder.decode(vin);
        return decoder.getVehicleDetails();
    }

    public boolean addVinToFleet(String vin, VehicleDetails vehicleDetails) {
        try {
            fleetStorage.addVehicleToFleet(vin, vehicleDetails);
        } catch (VehicleAlreadyInFleetException e) {
            return false;
        }
        return true;
    }

    public boolean removeVinFromFleet(String vin) {
        try {
            fleetStorage.removeVehicleFromFleet(vin);
        } catch (VehicleAlreadyInFleetException e) {
            return false;
        }
        return true;
    }

    public Map<String, VehicleDetails> listVehicles() {
        return fleetStorage.getStorage();
    }

    public boolean editVehicleDetails(String vin) {
        VehicleDetails oldvehicleDetails;
        try {
            oldvehicleDetails = fleetStorage.loadVehicleFromCache(vin);
        } catch (VehicleNotInFleetException e) {
            return false;
        }
        removeVinFromFleet(vin);
        //take user input and place it here
        String make = null;
        String model = null;
        String year = null;
        String fuelType = null;
        String engineSize = null;
        String unitNumber = null;
        VehicleDetails overrides = new VehicleDetails(null, make, model, year, fuelType, engineSize);
        addVinToFleet(vin, oldvehicleDetails.withOverrides(overrides));
        return true;
    }
}
