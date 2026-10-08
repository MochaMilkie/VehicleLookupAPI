package me.mochamilkie.vehiclelookupapi.UserInteractions;

import me.mochamilkie.vehiclelookupapi.ErrorResponses;
import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVehicleSetupException;
import me.mochamilkie.vehiclelookupapi.Exceptions.MissingDetailsException;
import me.mochamilkie.vehiclelookupapi.Exceptions.VehicleAlreadyInFleetException;
import me.mochamilkie.vehiclelookupapi.Exceptions.VehicleNotInFleetException;
import me.mochamilkie.vehiclelookupapi.Fleet.FleetStorage;
import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;
import me.mochamilkie.vehiclelookupapi.Lookup.VinDecoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class UserInteractionsService {
    private FleetStorage fleetStorage = new FleetStorage();

    public UserInteractionsService() {
    }

    public VehicleDetails decodeVin(String vin) {
        VinDecoder decoder = new VinDecoder(RestClient.builder());
        decoder.decode(vin);
        return decoder.getVehicleDetails();
    }

    public ErrorResponses addVinToFleet(String vin, VehicleDetails vehicleDetails) {
        try {
            fleetStorage.addVehicleToFleet(vin, vehicleDetails);
        } catch (VehicleAlreadyInFleetException e) {
            return ErrorResponses.VEHICLEALREADYINFLEET;
        }
        catch(MissingDetailsException e) {
            summonMissingDetailsDialog(vin, vehicleDetails);
            return ErrorResponses.MISSINGVEHICLEDETAILS;
        }
        return ErrorResponses.NOERROR;
    }
    public void summonMissingDetailsDialog(String vin, VehicleDetails vehicleDetails) {
        List<String> list = vehicleDetails.missingFields();
        if(list.isEmpty())
            return;
        if(list.contains("vin")){
            throw new InvalidVehicleSetupException();
        }
        boolean missingMake = list.contains("make");
        boolean missingModel = list.contains("model");
        boolean missingYear  = list.contains("year");
        boolean missingFuelType  = list.contains("fuelType");
        boolean missingEngineSize  = list.contains("engineSize");
        if(missingMake){

        }

    }

    //String vin, String make, String model, String year, String fuelType, String engineSize

    public ErrorResponses removeVinFromFleet(String vin) {
        try {
            fleetStorage.removeVehicleFromFleet(vin);
        } catch (VehicleAlreadyInFleetException e) {
            return ErrorResponses.VEHICLEALREADYINFLEET;
        }
        return ErrorResponses.NOERROR;
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
