package de.tekup.locationappb.security.services;

import de.tekup.locationappb.security.entites.Role;
import de.tekup.locationappb.security.entites.User;
import de.tekup.locationappb.security.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder bcryptPasswordEncoder;

    public void registerUser(User user){
        user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }

    public User getByUsername(String name) {
        return userRepository.findByUsername(name).get();
    }
}
