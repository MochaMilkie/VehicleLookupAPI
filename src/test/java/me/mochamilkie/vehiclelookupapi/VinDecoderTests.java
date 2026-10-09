package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class VinDecoderTests {

    @Test
    void validVinIsAccepted() {
        Assertions.assertDoesNotThrow(() -> new VIN("1FTRW12W06KD29937"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1FTRW12W06KD2993I", "1FTRW12W06KD2993O", "1FTRW12W06KD29937X"})
    void invalidVinIsNotAccepted(String bad) {
        Assertions.assertThrows(InvalidVinException.class, () -> new VIN(bad));
    }
    @Test
    void nullVinIsNotAccepted() {
        Assertions.assertThrows(InvalidVinException.class, () -> new VIN(null));
    }
}
