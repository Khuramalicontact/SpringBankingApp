package be.intecbrussel.banking_app_spring.service;

import be.intecbrussel.banking_app_spring.model.BankAccount;
import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.model.Transaction;
import be.intecbrussel.banking_app_spring.repository.BankAccountRepository;
import be.intecbrussel.banking_app_spring.repository.ClientRepository;
import be.intecbrussel.banking_app_spring.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.TargetAware;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TransactionService {

    private ClientService clientService;
    private ClientRepository clientRepository;
    private BankAccountService bankAccountService;
    private BankAccountRepository bankAccountRepository;

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionrepository,BankAccountService bankAccountService, ClientService clientService) {
        this.transactionRepository = transactionrepository;
        this.bankAccountService = bankAccountService;
        this.clientService = clientService;
    }

    public void transferMoney(int recieverId, int senderId, double amount) {
        Optional<Client> reciever = clientRepository.findById(recieverId);
        Optional<Client> sender = clientRepository.findById(senderId);

        Transaction transaction1 = new Transaction();

        transaction1.setSenderAccount(sender.get().getBankAccounts().get(senderId));
        transaction1.setReceiverAccount(reciever.get().getBankAccounts().get(recieverId));
        transaction1.setAmountToSend(amount);


        if(transaction1.getSenderAccount().getBalance() <= amount){
            System.out.println("ERROR UR DONT HAVE ENOUGH MONEY");
        }else{
            transaction1.getSenderAccount().setBalance(transaction1.getSenderAccount().getBalance()-amount);
            transaction1.getReceiverAccount().setBalance(transaction1.getReceiverAccount().getBalance()+amount);
            System.out.println(amount + "Has been transacted");
            transactionRepository.save(transaction1);
        }

    }}
