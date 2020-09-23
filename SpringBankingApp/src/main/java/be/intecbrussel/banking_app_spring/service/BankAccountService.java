package be.intecbrussel.banking_app_spring.service;

import be.intecbrussel.banking_app_spring.model.BankAccount;
import be.intecbrussel.banking_app_spring.model.Client;
import be.intecbrussel.banking_app_spring.repository.BankAccountRepository;
import com.sun.xml.bind.v2.runtime.reflect.opt.OptimizedAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class BankAccountService{

    private ClientService clientService;

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, ClientService clientService) {
        this.bankAccountRepository = bankAccountRepository;
        this.clientService = clientService;
    }

    public void createBankAccount(int customerId){
        Optional<Client> client = clientService.findById(customerId);
        BankAccount bankAccount = new BankAccount(client.get());
        client.get().getBankAccounts().add(bankAccount);
        if(client.isPresent()) {
            bankAccountRepository.save(bankAccount);
        } else {
            System.out.println("Cant find client for id = " + customerId);
        }
    }

    public void saveBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }
//
//    public void transactionToBankAccount(int receiverBankAccountId, int senderBankAccountId, double amountToSend) {
//        Optional<BankAccount> receiverBankAccount = bankAccountRepository.findById(receiverBankAccountId);
//        Optional<BankAccount> senderBankAccount = bankAccountRepository.findById(senderBankAccountId);

//
//        if (receiverBankAccount.isPresent() && senderBankAccount.isPresent()) {
//            BankAccount receiver = receiverBankAccount.get();
//            BankAccount sender = senderBankAccount.get();
//
//            if (sender.getBalance() <= amountToSend) {
//                System.out.println("U broke");
//
//            } else {
//                double newBalance = receiver.getBalance() + amountToSend;
//                receiver.setBalance(newBalance);
//                receiver.setPreviousTransaction(+amountToSend);
//
//                double newBalanceS = sender.getBalance() - amountToSend;
//                sender.setBalance(newBalanceS);
//                sender.setPreviousTransaction(-amountToSend);
//
//                bankAccountRepository.save(receiver);
//                bankAccountRepository.save(sender);
//
//            }
//
//        }
//
//
//    }

//    public void insertMoneyToBank(int receiverId,String nameSender, String dateOfBirthSender,double amount){
//        Optional<BankAccount> receiverBankAccount = bankAccountRepository.findById(receiverId);
//
//        if(receiverBankAccount.isPresent()){
//            BankAccount receiver = receiverBankAccount.get();
//
//            double newBalance = receiver.getBalance() + amount;
//            receiver.setBalance(newBalance);
//            receiver.setPreviousTransaction(+amount);
//
//            bankAccountRepository.save(receiver);
//        }else{
//            System.out.println("ERROR USER ID NOT FOUND");
//        }
//    }
//
//
//    public void scheduledTransaction(int receiverId,int senderBankAccountId, double amountToSend){
//        Optional<BankAccount> receiverBankAccount = bankAccountRepository.findById(receiverId);
//        Optional<BankAccount> senderBankAccount = bankAccountRepository.findById(senderBankAccountId);
//
//
//        if (receiverBankAccount.isPresent() && senderBankAccount.isPresent()) {
//            BankAccount receiver = receiverBankAccount.get();
//            BankAccount sender = senderBankAccount.get();
//
//            if (sender.getBalance() <= amountToSend) {
//                System.out.println("U broke");
//
//            } else {
//                double newBalance = receiver.getBalance() + amountToSend;
//                receiver.setBalance(newBalance);
//                receiver.setPreviousTransaction(+amountToSend);
//
//                double newBalanceS = sender.getBalance() - amountToSend;
//                sender.setBalance(newBalanceS);
//                sender.setPreviousTransaction(-amountToSend);
//
//                bankAccountRepository.save(receiver);
//                bankAccountRepository.save(sender);
//
//            }
//
//        }
//
//
//    }

    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.addAll(bankAccountRepository.findAll());
        return bankAccounts;
    }
}
