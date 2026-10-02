package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;
import me.mochamilkie.vehiclelookupapi.Lookup.VinDecoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClient;

@SpringBootTest
public class VehicleOverridesTest {
    @Test
    public void overridesNullTest() {
        VinDecoder vinDecoder = new VinDecoder(RestClient.builder());
        VehicleDetails mockManualDetails = new VehicleDetails(null,null,null,null,null,null);
        vinDecoder.decode("1YVHZ8DHXC5M26142");
        VehicleDetails vehicleDetails = vinDecoder.getVehicleDetails();
        VehicleDetails complete = vehicleDetails.withOverrides(mockManualDetails);
        Assertions.assertEquals(vehicleDetails, complete);

    }
    @Test
    public void overridesTest() {
        VinDecoder vinDecoder = new VinDecoder(RestClient.builder());
        VehicleDetails mockManualDetails = new VehicleDetails("1YVHZ8DHXC5M26142","9","9","9","9","9");
        vinDecoder.decode("1YVHZ8DHXC5M26142");
        VehicleDetails vehicleDetails = vinDecoder.getVehicleDetails();
        VehicleDetails complete = vehicleDetails.withOverrides(mockManualDetails);
        Assertions.assertEquals(complete,mockManualDetails);
    }
}
