package me.mochamilkie.vehiclelookupapi.Lookup;

import me.mochamilkie.vehiclelookupapi.Exceptions.VinNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class VinDecoder {
    private final RestClient restClient;
    public VinDecoder(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues").build();
    }

    private VehicleDetails vehicleDetails;

    public void decode(String vin) {

        NhtsaResponse response = restClient.get().uri("/{vin}?format=json", vin)
                .retrieve().body(NhtsaResponse.class);
        if (response == null || response.results().isEmpty()) {
            throw new VinNotFoundException(vin);
        }
        NhtsaResult r = response.results().getFirst();
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
