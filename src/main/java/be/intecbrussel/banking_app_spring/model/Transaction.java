package be.intecbrussel.banking_app_spring.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private BankAccount receiverAccount;

    @OneToOne
    private BankAccount senderAccount;

    private double amountToSend;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BankAccount getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(BankAccount receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public BankAccount getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(BankAccount senderAccount) {
        this.senderAccount = senderAccount;
    }

    public double getAmountToSend() {
        return amountToSend;
    }

    public void setAmountToSend(double amountToSend) {
        this.amountToSend = amountToSend;
    }
}
