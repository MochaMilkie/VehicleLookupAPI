package me.mochamilkie.vehiclelookupapi.UserInteractions;

import me.mochamilkie.vehiclelookupapi.ErrorResponses;
import me.mochamilkie.vehiclelookupapi.Lookup.VehicleDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainPage {

    private final UserInteractionsService userService;

    public MainPage(UserInteractionsService userInteractionsService) {
        this.userService = userInteractionsService;

    }
    @GetMapping("/decode")
    public VehicleDetails decodeVin(@RequestParam String vin) {
        return this.userService.decodeVin(vin);

    }
    @GetMapping("/addVinToFleet")
    public ErrorResponses addVinToFleet(@RequestParam String vin, @RequestParam VehicleDetails vehicleDetails) {
        return this.userService.addVinToFleet(vin, vehicleDetails);
    }
    @GetMapping("/editVehicleFromFleet")
    public void editVehicleFromFleet(@RequestParam String vin) {

    }
    @GetMapping("/deleteVehicleFromFleet")
    public ErrorResponses deleteVehicleFromFleet(@RequestParam String vin) {
        return this.userService.removeVinFromFleet(vin);
    }
    @GetMapping("/refreshVehicleFromNHTSA")
    public VehicleDetails refreshVehicleFromNHTSA(@RequestParam String vin) {
        return this.userService.decodeVin(vin);

    }
    @GetMapping("/error")
    public ErrorResponses error() {
        return ErrorResponses.NOERROR;
    }
}

