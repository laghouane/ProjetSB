package de.tekup.locationappb.services;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public List<Client> getAll(){
        return (List<Client>) clientRepository.findAll();
    }

    public Client getClientById(int id){
        return clientRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Client Id not found"));
    }

    //@PostConstruct
    private void addClientsToDB(){
        if(clientRepository.count()==0){
            saveClient(new Client("12345678","Doe","John","NY"));
            saveClient(new Client("12345679","Doe","Jane","Cal"));
        }
    }

    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }
}
