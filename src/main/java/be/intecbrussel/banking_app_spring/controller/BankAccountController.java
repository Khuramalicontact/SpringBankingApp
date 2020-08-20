package be.intecbrussel.banking_app_spring.controller;

import be.intecbrussel.banking_app_spring.model.BankAccount;
import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    BankAccountService bankAccountService;


    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankaccounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @PostMapping(value = "/bankaccounts/add", consumes = "application/json")
    public void addBankAccount(@RequestBody BankAccount bankAccount) {
        System.out.println("saving bankaccount");
        bankAccountService.saveBankAccount(bankAccount);
    }


    @PostMapping(value = "/createClient/{idCardNumber}/{name}/{lastname}/{dateOfBirth},{address}")
    public void createClient(@PathVariable int idCardNumber,@PathVariable String name, @PathVariable String lastName
    ,@PathVariable String dateOfBirth, @PathVariable String address){
        bankAccountService.createClient(idCardNumber,name,lastName,dateOfBirth,address);
    }

    @PostMapping(value = "/createBankacccount/{clientId}/{balance}")


//    @PostMapping(value = "/deposit/{receiverId}/{senderId}/{amount}")
//    public void transactionToBankAccount(@PathVariable int receiverId, @PathVariable int senderId, @PathVariable double amount) {
//        bankAccountService.transactionToBankAccount(receiverId, senderId, amount);
//    }
//
//    @PostMapping(value = "/insertCash/{receiverId}/{nameSender}/{dateOfBirthSender}/{amount}")
//    public void insertMoneyToBank(@PathVariable int receiverId, @PathVariable String nameSender, @PathVariable String dateOfBirthSender, @PathVariable double amount){
//        bankAccountService.insertMoneyToBank(receiverId,nameSender,dateOfBirthSender, amount);
//    }
//
//
//    @PostMapping(value = "/scheduledTransaction/{receiverId}/{senderId}/{amount}")
//    public void scheduledTransaction(@PathVariable int receiverId,@PathVariable int senderId,@PathVariable double amount){
//        bankAccountService.scheduledTransaction(receiverId,senderId,amount);
//    }


}
