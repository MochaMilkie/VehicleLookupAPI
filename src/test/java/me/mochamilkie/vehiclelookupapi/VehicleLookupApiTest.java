package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VehicleLookupApiTest{

    @Test
    void contextLoads() {
        Controller controller = new Controller();
        //Preverified vin to make sure decoder is working on compile
        VehicleDetails vehicleDetails = controller.getByVin("1YVHZ8DHXC5M26142");
        String expectedYear = "2012";
        Assertions.assertEquals(expectedYear, vehicleDetails.year());
        String expectedMake = "MAZDA";
        Assertions.assertEquals(expectedMake, vehicleDetails.make());
        String expectedModel = "Mazda6";
        Assertions.assertEquals(expectedModel, vehicleDetails.model());


    }

}
