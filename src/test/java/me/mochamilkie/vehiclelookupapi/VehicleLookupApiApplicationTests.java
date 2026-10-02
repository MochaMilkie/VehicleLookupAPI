package me.mochamilkie.vehiclelookupapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class VehicleLookupApiApplicationTests {

    @Test
    void contextLoads() {
        Controller controller = new Controller();
        //Preverified vin to make sure decoder is working on compile
        VehicleDetails vehicleDetails = controller.getByVin("1YVHZ8DHXC5M26142");
        int expectedYear = 2012;
        Assertions.assertEquals(expectedYear, vehicleDetails.getYear());
        String expectedMake = "MAZDA";
        Assertions.assertEquals(expectedMake, vehicleDetails.getMake());
        String expectedModel = "Mazda6";
        Assertions.assertEquals(expectedModel, vehicleDetails.getModel());


    }

}
