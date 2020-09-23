package be.intecbrussel.banking_app_spring.service;

import be.intecbrussel.banking_app_spring.model.BankAccount;
import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BankAccountService {

    private ClientService clientService;

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, ClientService clientService) {
        this.bankAccountRepository = bankAccountRepository;
        this.clientService = clientService;
    }

    public void createBankAccount(int customerId) {
        Optional<Client> client = clientService.findById(customerId);
        BankAccount bankAccount = new BankAccount(client.get());
        client.get().getBankAccounts().add(bankAccount);
        if (client.isPresent()) {
            bankAccountRepository.save(bankAccount);
        } else {
            System.out.println("Can't find clients id = " + customerId);
        }
    }

    public void saveBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.addAll(bankAccountRepository.findAll());
        return bankAccounts;
    }
}
