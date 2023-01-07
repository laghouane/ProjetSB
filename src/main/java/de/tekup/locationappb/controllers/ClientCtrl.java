package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClientCtrl {

    private ClientService clientService;

    @RequestMapping(path = "/clients/add",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @RequestMapping(path = "/clients/all",method = RequestMethod.GET)
    public List<Client> getClients(){
        return clientService.getAll();
    }

    //@RequestMapping(path = "/clients/{id}",method = RequestMethod.GET)
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable("id") int clientId){
       return clientService.getClientById(clientId);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgsException(IllegalArgumentException e){
        return "Error in search :"+e.getMessage();
    }
}
