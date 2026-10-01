package me.mochamilkie.vehiclelookupapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    @GetMapping("/vehicles")
    public VehicleDetails getByVin(@RequestParam String vin) {
        return new VehicleDetails(vin, "Test Make", "Test Model", 9999, "Test Fuel Type", "Test Engine");
    }

}
