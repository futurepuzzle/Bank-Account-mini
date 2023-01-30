/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author scr3w
 */
public class BankAccount {

    //declare private variables
    private int accountNumber;
    //removing these: so we can us customer class
//    private String firstName;
//    private String lastName;
//    private char middleInit;
    //call customer class
    private Customer customer;
    private float balance;
    //convert date string to date
    //can call freely from anything in the package
    private Date lastTransaction; //date 

    //create default constructor
    public BankAccount() {
        //super(firstName, lastName, middleInit);
        this.customer = new Customer(0000, " ", " ", ' ');
        this.accountNumber = 0000;
//        this.firstName = " ";
//        this.lastName = " ";
//        this.middleInit = ' ';
        this.balance = 0;
        this.lastTransaction = new Date (1,1,2023);
    }

    //create main constructor
    public BankAccount(int accountNumber, Customer customer, float balance, Date lastTransaction) {
        this.customer=customer;
        this.accountNumber = accountNumber;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.middleInit = middleInit;
        this.balance = balance;
        this.lastTransaction = lastTransaction;
    }

    //get getters 
    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public char getMiddleInit() {
//        return middleInit;
//    }

    public float getBalance() {
        return balance;
    }

    public Date getLastTransaction() {
        return lastTransaction;
    }

    //set setters
    public void setAccountNumber(int accountNumber) {
        if (accountNumber >= 0) {
            this.accountNumber = accountNumber;
        }
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setMiddleInit(char middleInit) {
//        this.middleInit = middleInit;
//    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setLastTransaction(Date lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    //methods
    public void deposit(float amount, Date lastTransaction) {
//        if (amount >= 0) {
//            this.balance = balance + amount;
//        } else {
//            System.out.println("Invalid amount, deposit must be a positive amount");
//        }
//        this.lastTransaction = lastTransaction;
        //short way
        setBalance(amount + getBalance());
        setLastTransaction(lastTransaction);

    }

    public void withdraw(float amount, Date lastTransaction) {
//        if (amount >= 0) {
//            this.balance = balance - amount;
//        } else {
//            System.out.println("Invalid amount, withdrawal must be a positive amount");
//        }
//        this.lastTransaction = lastTransaction;

        //short way
        setBalance(getBalance() - amount);
        setLastTransaction(lastTransaction);

    }

    public void transfer(float amount, BankAccount otherAccount, Date lastTransaction) {
//        if (amount >= 0) {
//            otherAccount.balance = otherAccount.balance + amount;
//            this.balance = balance - amount;
//            this.lastTransaction = lastTransaction;
//        } else {
//            System.out.println("invalid amount, must be positive");
//        }
        
        //short way
        withdraw(amount, lastTransaction);
        otherAccount.deposit(amount, lastTransaction);
        
        
    }

}
