package me.mochamilkie.vehiclelookupapi.Fleet;

import me.mochamilkie.vehiclelookupapi.Exceptions.*;
import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;
import me.mochamilkie.vehiclelookupapi.Lookup.VinDecoder;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FleetStorage {
    Map<String, VehicleDetails> storage = new HashMap<>();
    VehicleDetails dummyVehicle = new VehicleDetails(null,  null,  null, null, null, null);

    public FleetStorage() {

    }
    public VehicleDetails loadVehicleFromCache(String vin){
        VehicleDetails vehicleDetails = storage.getOrDefault(vin, dummyVehicle);
        if(vehicleDetails == dummyVehicle || vehicleDetails == null) {
            throw new VehicleNotInFleetException();
        }
        return vehicleDetails;
    }
    public void loadVehicleListFromStorage(String vin){
        //Load vehicle list from SQL to local map for caching and reduced SQL throughput

    }
    public void addVehicleToFleet(String vin, VehicleDetails vehicleDetails){
        //Figure out how to take user input and apply it to the overrides.
        List<String> list = vehicleDetails.missingFields();
        if(list.isEmpty()){
            throw new MissingDetailsException();
        }
    }
    public void editVehicleDetailsFromCache(String vin, VehicleDetails vehicleDetails){
        VehicleDetails stored = storage.get(vin);
        if(stored == null){
            throw new VehicleNotInFleetException();
        }
        VehicleDetails complete = stored.withOverrides(vehicleDetails);
        storage.replace(vin, complete);

    }
    public void refreshVehicleDetailsFromNHTSA(String vin){
        VinDecoder vinDecoder = new VinDecoder(RestClient.builder());
        vinDecoder.decode(vin);
        VehicleDetails vehicleDetails = vinDecoder.getVehicleDetails();
        VehicleDetails manual = new VehicleDetails(null, null, null,null,null,null);
        VehicleDetails complete = vehicleDetails.withOverrides(manual);

        storage.putIfAbsent(vin, complete);
        //sql save
    }
    public void removeVehicleFromFleet(String vin){
        if(storage.containsKey(vin)){
            throw new VehicleNotInFleetException();
        }
        storage.remove(vin);
    }
    public Map<String, VehicleDetails> getStorage() {
        return storage;
    }
}
