package be.intecbrussel.banking_app_spring.service;

import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.model.Transaction;
import be.intecbrussel.banking_app_spring.repository.BankAccountRepository;
import be.intecbrussel.banking_app_spring.repository.ClientRepository;
import be.intecbrussel.banking_app_spring.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionService {

    private ClientService clientService;
    private ClientRepository clientRepository;
    private BankAccountService bankAccountService;
    private BankAccountRepository bankAccountRepository;

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(ClientRepository clientRepository, TransactionRepository transactionrepository, BankAccountService bankAccountService, ClientService clientService) {
        this.transactionRepository = transactionrepository;
        this.bankAccountService = bankAccountService;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void transferMoney(int receiverId, int senderId, double amount) {
        Optional<Client> receiver = clientRepository.findById(receiverId);
        Optional<Client> sender = clientRepository.findById(senderId);

        Transaction transaction1 = new Transaction();

        transaction1.setSenderAccount(sender.get().getBankAccounts().get(0));
        transaction1.setReceiverAccount(receiver.get().getBankAccounts().get(0));
        transaction1.setAmountToSend(amount);


        if (transaction1.getSenderAccount().getBalance() <= amount) {
            System.out.println("THERE IS NOT ENOUGH MONEY IN YOUR ACCOUNT");
        } else {
            transaction1.getSenderAccount().setBalance(transaction1.getSenderAccount().getBalance() - amount);
            transaction1.getReceiverAccount().setBalance(transaction1.getReceiverAccount().getBalance() + amount);
            System.out.println(amount + " got transferred to" + receiver.get().getName());
            clientRepository.save(receiver.get());
            clientRepository.save(sender.get());
            transactionRepository.save(transaction1);
        }

    }
}
