package be.intecbrussel.banking_app_spring.service;

import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findById(int clientId) {
        return clientRepository.findById(clientId);
    }


    public void createClient(int idCardNumber,String name,String lastName,String dateOfBirth, String address) {
        Client client = new Client();
        client.setIdCardNumber(idCardNumber);
        client.setName(name);
        client.setLastName(lastName);
        client.setAddress(address);

        int day = Integer.parseInt(dateOfBirth.substring(0,2)); //30082010      30
        int month = Integer.parseInt(dateOfBirth.substring(2,4));
        int year = Integer.parseInt(dateOfBirth.substring(4,8));

        LocalDate birthDate = LocalDate.of(year, month, day);

        client.setDateOfBirth(birthDate);

        clientRepository.save(client);
    }


    public void addNewClient(Client client){
        this.clientRepository.save(client);
    }

}
