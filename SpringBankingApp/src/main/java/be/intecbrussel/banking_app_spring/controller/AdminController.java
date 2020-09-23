package be.intecbrussel.banking_app_spring.controller;

import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.service.BankAccountService;
import be.intecbrussel.banking_app_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class AdminController {

    private BankAccountService bankAccountService;
    private ClientService clientService;


    @Autowired
    public void setBankAccountService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save_user")
    public String showUsers(@ModelAttribute("client")Client client202){
        clientService.addNewClient(client202);
        return "redirect:/";
    }


}
