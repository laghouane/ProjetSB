package de.tekup.locationappb.security.controllers;

import de.tekup.locationappb.security.entites.LoginRequest;
import de.tekup.locationappb.security.services.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthCtrl {

    private AuthenticationManager authManager;
    private TokenService tokenService;

    @PostMapping("/token")
    public String createToken(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        Authentication authentication = authManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        return tokenService.generateToken(authentication);
    }
}
