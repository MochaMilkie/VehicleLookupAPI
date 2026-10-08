package me.mochamilkie.vehiclelookupapi.VinDecoder;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidResponseFromNHTSAException;
import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import org.springframework.web.client.RestClient;

import java.util.List;

public class NHTSAClient {
    private final RestClient restClient;

    public NHTSAClient(RestClient.Builder clientBuilder) {
        this.restClient = clientBuilder.baseUrl("https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues").build();
    }

    public NHTSAResult decodeVin(VIN vin){
        if(!vin.validateVIN()) throw new InvalidVinException(vin);
        NHTSAResponse response = restClient.get().uri("/{vin}?format=json", vin.vin()).retrieve().body(NHTSAResponse.class);

        if(response == null) throw new InvalidResponseFromNHTSAException();
        if(response.results() == null) throw new InvalidResponseFromNHTSAException();

        return response.results().getFirst();
    }
}
