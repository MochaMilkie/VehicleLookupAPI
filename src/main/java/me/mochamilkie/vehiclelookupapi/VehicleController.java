package me.mochamilkie.vehiclelookupapi;

import me.mochamilkie.vehiclelookupapi.Exceptions.InvalidVinException;
import me.mochamilkie.vehiclelookupapi.VehicleData.VIN;
import me.mochamilkie.vehiclelookupapi.VehicleData.Vehicle;
import me.mochamilkie.vehiclelookupapi.VehicleData.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class VehicleController {
    private VehicleService vehicleService;
    public VehicleController() {
        this.vehicleService = new VehicleService();
    }
    @GetMapping("/vin-decoder")
    public Vehicle decodeVIN(@RequestParam String vin) {
        VIN vin1 =  new VIN(vin);
        return vehicleService.createVehicleFromNHTSA(vin1);
    }
}
