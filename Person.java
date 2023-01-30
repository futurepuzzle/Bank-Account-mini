/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 * Person class that will be the basis for customer 
 * basically we will create a customer class that is derived from person
 * diamond = "has a"
 * arrow = "is a"
 * @author scr3w
 */
public class Person {
    private String firstName;
    private String lastName;
    private char middleInit;
    
    public Person(){
    }

    public Person(String firstName, String lastName, char middleInit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = middleInit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getMiddleInit() {
        return middleInit;
    }

    public void setMiddleInit(char middleInit) {
        this.middleInit = middleInit;
    }
    
    //method for grabbing the full name
    public String getFullName(){
        return lastName + ", " + firstName + " " + middleInit + ".";
    }
    
}
