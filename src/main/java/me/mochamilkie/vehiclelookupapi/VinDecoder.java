package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.Exceptions.VinNotFoundException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Array;
import java.util.Map;
@Service
public class VinDecoder {
    private final RestClient restClient;
    public VinDecoder(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues/").build();
    }

    private VehicleDetails vehicleDetails;

    public void decode(String vin) {

        NhtsaResponse response = restClient.get().uri("/vehicles/DecodeVinValues/{vin}?format=json", vin)
                .retrieve().body(NhtsaResponse.class);
        if (response == null || response.results().isEmpty()) {
            throw new VinNotFoundException(vin);
        }
        NhtsaResult r = response.results().get(0);
        if (r.make() == null || r.make().isBlank()) {
            throw new VinNotFoundException(vin);
        }
        vehicleDetails = new VehicleDetails(vin, r.make(), r.model(),
                r.year(), r.fuelType(),
                r.engineSize() + "L");

        //decode vin using NHTSA
        //"https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues/"+vin+"?format=json"


//        int year = 9999;
//        String make = "";
//        String model = "";
//        String fuelType = "";
//        String engine = "";
        //parse and make sure we got a valid response
        //NHTSA decodes and verifies vin when requested. Consider letting them do the check instead
    }
    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

}
