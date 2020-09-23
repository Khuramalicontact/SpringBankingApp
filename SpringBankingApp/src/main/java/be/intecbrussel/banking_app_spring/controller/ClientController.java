package be.intecbrussel.banking_app_spring.controller;

import be.intecbrussel.banking_app_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/createClient/{idCardNumber}/{name}/{lastName}/{dateOfBirth}/{address}")
    public void createClient(@PathVariable int idCardNumber, @PathVariable String name, @PathVariable String lastName
            , @PathVariable String dateOfBirth, @PathVariable String address) {
        clientService.createClient(idCardNumber,name,lastName,dateOfBirth,address);
    }
}
