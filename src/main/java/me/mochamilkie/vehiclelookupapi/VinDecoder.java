package me.mochamilkie.vehiclelookupapi;

import org.apache.logging.log4j.util.Strings;

import java.lang.reflect.Array;
import java.util.Map;

public class VinDecoder {
    public VinDecoder() {

    }

    private VehicleDetails vehicleDetails;

    public boolean decode(String vin) {
        //Parse the vin, then verify check digit and format. Give a boolean response
        if (!(vin.toCharArray().length == 12)) return false;
        vin = vin.toUpperCase();
        //decode vin using NHTSA
        int year = 9999;
        String make = "c";
        String model = "";
        String fuelType = "";
        String engine = "";
        //parse and make sure we got a valid response

        vehicleDetails = new VehicleDetails(vin, make, model, year, fuelType, engine);
        return true;
    }
    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

}
