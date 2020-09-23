package be.intecbrussel.banking_app_spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    private int version;

    private String bankAccNr;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    private double balance;

    @ManyToMany
    private List<Transaction> transactions;


    public BankAccount(Client client) {
        this.client = client;
        this.balance = 1000;
        this.bankAccNr = generateRandomAccountNumber();
        transactions = new ArrayList<>();
    }

    public BankAccount(Client client, double balance) {
        this.client = client;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        int firstPart = random.nextInt(999);
        int secondPart = random.nextInt(9999999);
        int thirdPart = random.nextInt(99);

        return "" + firstPart + "-" + secondPart + "-" + thirdPart;
    }

    public String getBankAccNr() {
        return bankAccNr;
    }

    public void setBankAccNr(String bankAccNr) {
        this.bankAccNr = bankAccNr;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", version=" + version +
                ", bankAccNr='" + bankAccNr + '\'' +
                ", client=" + client +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}