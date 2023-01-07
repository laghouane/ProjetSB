package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Integer> {

}
