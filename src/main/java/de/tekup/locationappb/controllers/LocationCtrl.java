package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Location;
import de.tekup.locationappb.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LocationCtrl {
    private LocationService locationService;

    @PostMapping("/locations/register/client/{idClient}/voiture/{idVoiture}")
    public Location registerLocation(@RequestBody Location location,
                                     @PathVariable("idClient") int idClient,
                                     @PathVariable("idVoiture") int idVoiture){
        return locationService.registerLocation(location,idClient,idVoiture);
    }
}
