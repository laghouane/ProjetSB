package de.tekup.locationappb.security.repos;

import de.tekup.locationappb.security.entites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
