package bank.services;

import bank.models.Client;
import bank.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> list() {
        return clientRepository.findAll();
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }
}