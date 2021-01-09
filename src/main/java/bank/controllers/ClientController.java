package bank.controllers;

import bank.models.Client;
import bank.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
class ClientController {

    private final ClientService clientService; //is injected by constructor into the controller.

    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    ResponseEntity<Client> save(@Valid @RequestBody Client newClient) {
        return new ResponseEntity<>(clientService.save(newClient), HttpStatus.CREATED);
    }

    @GetMapping("/clients")
    List<Client> all() {
        return clientService.list();
    }
}