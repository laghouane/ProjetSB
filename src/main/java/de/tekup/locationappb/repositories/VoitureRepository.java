package de.tekup.locationappb.repositories;


import de.tekup.locationappb.entites.Voiture;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VoitureRepository extends PagingAndSortingRepository<Voiture,Integer> {
}
