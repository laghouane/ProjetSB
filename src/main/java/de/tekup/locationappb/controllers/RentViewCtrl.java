package de.tekup.locationappb.controllers;

import de.tekup.locationappb.security.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class RentViewCtrl {
    private UserService userService;
    @GetMapping("/rent")
    public String rentPage(Model model, Principal principal){
        model.addAttribute("user",userService.getByUsername(principal.getName()));
        return "rent";
    }
}
