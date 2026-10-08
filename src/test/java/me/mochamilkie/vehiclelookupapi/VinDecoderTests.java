package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class VinDecoderTests {

    @Test
    public void VinVerificationTest(TestReporter testReporter) {
        VIN vin = new VIN("1FTRW12W06KD29937");
        Assertions.assertNotNull(vin);
    }
}
