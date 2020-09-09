package be.intecbrussel.banking_app_spring.controller;

import be.intecbrussel.banking_app_spring.model.BankAccount;
import be.intecbrussel.banking_app_spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }


    @PostMapping(value = "/transfer/{recieverId}/{senderId}/{amount}")
    public void transferMoney(@PathVariable int recieverId, @PathVariable int senderId, @PathVariable double amount){
        transactionService.transferMoney(recieverId,senderId,amount);

    }
}
