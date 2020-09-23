package be.intecbrussel.banking_app_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Version
    private int version;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<BankAccount> bankAccounts;

    private int idCardNumber;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private String password;

    public Client() {
    }

    public Client(int idCardNumber, String name, String lastName, LocalDate dateOfBirth, String address, String password) {
        this.idCardNumber = idCardNumber;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
    }


    public Client(int idCardNumber, String name, String lastName, String address, String password) {
        this.idCardNumber = idCardNumber;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public int getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(int idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Client{" +
                "customerId=" + customerId +
                ", version=" + version +
                ", bankAccounts=" + bankAccounts +
                ", idCardNumber=" + idCardNumber +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
