package me.mochamilkie.vehiclelookupapi.VinDecoder;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidResponseFromNHTSAException;
import me.mochamilkie.vehiclelookupapi.VehicleController;
import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import me.mochamilkie.vehiclelookupapi.VehicleData.Vehicle;
import me.mochamilkie.vehiclelookupapi.VehicleData.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Year;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers= VehicleController.class)
public class VehicleControllerTests {
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    VehicleService vehicleService;
    @Test
    void validVinReturnsVehicle() throws Exception {
        VIN vin = new VIN("1FTRW12W06KD29937");
        when(vehicleService.createVehicleFromNHTSA(vin)).thenReturn(new Vehicle(vin, Year.of(2006), "FORD", "F150"));
        mockMvc.perform(get("/vin-decoder").param("vin", "1FTRW12W06KD29937"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.make").value("FORD"));

    }
    @Test
    void upstreamFailureReturnsErrorBody() throws Exception {
        when(vehicleService.createVehicleFromNHTSA(any()))
                .thenThrow(new InvalidResponseFromNHTSAException());

        mockMvc.perform(get("/vin-decoder").param("vin", "1FTRW12W06KD29937"))
                .andExpect(jsonPath("$.error").value("INVALID_NHTSA_RESPONSE"));
    }

    @Test
    void missingVinParameterReturns400() throws Exception {
        mockMvc.perform(get("/vin-decoder"))
                .andExpect(status().isBadRequest());
    }
}
