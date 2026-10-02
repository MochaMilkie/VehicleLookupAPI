package me.mochamilkie.vehiclelookupapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VehicleLookupApiApplicationTests {

    @Test
    void contextLoads() {
        Controller controller = new Controller();
        controller.getByVin(String.valueOf(000000));
        assert true();

    }

}
