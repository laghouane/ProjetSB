package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Long> {
}
