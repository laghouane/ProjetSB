package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.entites.Location;
import de.tekup.locationappb.entites.Voiture;
import de.tekup.locationappb.repositories.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {
    private LocationRepository locationRepository;
    private ClientService clientService;
    private VoitureService voitureService;

    public Location registerLocation(Location location,
                                     int idClient,
                                     int idVoiture){
        Client client = clientService.getClientById(idClient);
        Voiture voiture = voitureService.getVoitureById(idVoiture);
        location.setClient(client);
        location.setVoiture(voiture);
        return locationRepository.save(location);

    }
}
