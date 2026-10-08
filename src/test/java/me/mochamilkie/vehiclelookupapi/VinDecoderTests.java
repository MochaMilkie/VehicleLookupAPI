package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VinDecoderTests {

    @Test
    public void VinVerificationTest() {
        VIN vin = new VIN("1FTRW12W06KD29937");
        Assertions.assertTrue(vin.validateVIN());
    }
}
