/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BankAccount;

import java.util.Scanner;

/**
 *
 * @author scr3w
 */
public class BankAccountProgram {

    //declare scanner as glodal so you don't have to declare it multiple times
    public static Scanner input;
    //global vars
    public static BankAccount[] accounts;

    public static void main(String[] args) {
        BankAccountProgram bap = new BankAccountProgram();
        //bap.getData();
        accounts = FileHandler.getData("233BankAccountTestData.txt");
        int choice = 0;
        while (choice != 7) {
            choice = bap.showMenu();
            bap.executeChoices(choice);
        }

    }

    public BankAccountProgram() {
        //summon the scanner
        input = new Scanner(System.in);
    }

    public void getData() {
        //call BankAccount
        accounts = new BankAccount[5];
        //add data to the accounts
        //f denotes float
        accounts[0] = new BankAccount(1001, new Customer(0, "Blin ", " McBLinz", 'Q'), 3200.50f, new Date(7, 9, 2020));
        accounts[1] = new BankAccount(1002, new Customer(1, "Piz ", " Dec", 'C'), 500.00f, new Date(9, 9, 1998));
        accounts[2] = new BankAccount(1003, new Customer(2, "Cyka ", " Blin", 'D'), 100000.00f, new Date(10, 9, 2001));
        accounts[3] = new BankAccount(1004, new Customer(3, "Usagi ", " Yojimbo", 'T'), 75.00f, new Date(11, 5, 1699));
        accounts[4] = new BankAccount(1005, new Customer(4, "Darth ", " Wader", 'K'), 205.45f, new Date(10, 7, 2045));
    }

    //method to show the menu and ask what option the user wants
    public int showMenu() {
        System.out.println("1. Display all accounts");
        System.out.println("2. Display account info");
        System.out.println("3. Edit Account info");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Transfer");
        System.out.println("7. Quit");
        //get user's choice as an int
        int choice = input.nextInt();
        return choice;
    }

    //method to execute choice
    public void executeChoices(int choice) {
        if (choice == 1) {
            displayAllAccounts();
        } else if (choice == 2) {
            displayAccountInfo();
        } else if (choice == 3) {
            editAccountInfo();

        } else if (choice == 4) {
            deposit();
        } else if (choice == 5) {
            withdraw();
        } else if (choice == 6) {
            transfer();
        } else if (choice == 7) {
            quit();
        }
    }

    //method to display acccounts'
    public void displayAllAccounts() {
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Account Number: " + accounts[i].getAccountNumber());
            System.out.println("Account Number: " + accounts[i].getCustomer().customerDetails());
            System.out.println("Balance: " + accounts[i].getBalance());
            System.out.println("Last Transaction: " + accounts[i].getLastTransaction());
            System.out.println("----------------");
        }
    }

    //method for displaying account info
    public void displayAccountInfo() {
        System.out.println("Please enter an account number");
        int num = input.nextInt();

        for (int i = 0; i < accounts.length; i++) {
            //if statement so that it only displays if the number input is valid
            if (accounts[i].getAccountNumber() == num) {
                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                System.out.println("Account Number: " + accounts[i].getCustomer().customerDetails());
                System.out.println("Balance: " + accounts[i].getBalance());
                System.out.println("Last Transaction: " + accounts[i].getLastTransaction());
                System.out.println("----------------");
            }
        }
    }

    public void editAccountInfo() {
        System.out.println("please enter an account number");
        int num = input.nextInt();

        System.out.println("What do you want to edit?");
        System.out.println("1.First Name");
        System.out.println("2.Middle initial");
        System.out.println("3.Last Name");
        int subchoice = input.nextInt();

        if (subchoice == 1) {
            System.out.println("Please enter a first Name");
            String First = input.next();
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].getAccountNumber() == num) {
                    accounts[i].getCustomer().setFirstName(First);
                }
            }
        } else if (subchoice == 2) {
            System.out.println("Please enter a Middle Initial");
            String Last = input.next();
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].getAccountNumber() == num) {
                    accounts[i].getCustomer().setLastName(Last);
                }
            }
        } else if (subchoice == 3) {
            System.out.println("Please enter a Last Name");
            char Mid = input.next().charAt(0);
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].getAccountNumber() == num) {
                    accounts[i].getCustomer().setMiddleInit(Mid);
                }
            }
        }
    }

    public void deposit() {
        System.out.println("Please enter an account number to deposit into:");
        int num = input.nextInt();
        System.out.println("How much are you depositing?");
        float deposit = input.nextFloat();
        //get date info
        System.out.println("Enter the day");
        int day = input.nextInt();
        System.out.println("Enter the month");
        int month = input.nextInt();
        System.out.println("Enter the year");
        int year = input.nextInt();
        //combine day month year into the date variable
        Date date = new Date(day, month, year);

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == num) {
                accounts[i].deposit(deposit, date);
            }
        }
    }

    public void withdraw() {
        System.out.println("Please enter an account number to withdraw from:");
        int num = input.nextInt();
        System.out.println("How much are you withdrawing?");
        float withdrawal = input.nextFloat();
        //get date info
        System.out.println("Enter the day");
        int day = input.nextInt();
        System.out.println("Enter the month");
        int month = input.nextInt();
        System.out.println("Enter the year");
        int year = input.nextInt();
        //combine day month year into the date variable
        Date date = new Date(day, month, year);

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == num) {
                accounts[i].withdraw(withdrawal, date);
            }
        }
    }

    public void transfer() {
        System.out.println("please enter the account num of transfer sender");
        int num = input.nextInt();
        System.out.println("Please enter account num of receiver");
        int numOther = input.nextInt();
        System.out.println("How much are you transferring?");
        float transfer = input.nextFloat();
        //get date 
        System.out.println("Enter the day");
        int day = input.nextInt();
        System.out.println("Enter the month");
        int month = input.nextInt();
        System.out.println("Enter the year");
        int year = input.nextInt();
        //combine day month year into the date variable
        Date date = new Date(day, month, year);

        //find index of specific account in the array
        int otherIndex = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == numOther) {
                otherIndex = i;
            }
        }
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == num) {
                accounts[i].transfer(transfer, accounts[otherIndex], date);
            }
        }
    }

    public void quit() {
        System.out.println("Exiting Program...");
    }
}
