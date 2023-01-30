/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 * customer class derived from Person parent class
 * @author scr3w
 */
//using extends to indicate that Person is the parent class
public class Customer extends Person {
    private int customerId;
    
    public Customer(){
    }
    
    public Customer(int customerId, String firstName, String lastName, char middleInit){
        //super sends info to parent class to look at the constructor requirements
        super(firstName, lastName, middleInit);
        this.customerId = customerId;
    }
    
    //getters and setters already exist for name info so we only need them for customerId

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String customerDetails() {
        //because this is declared as a child class it also inherets the methods from its parent
        //hence why we can call the getFullName method
        return "Customer Id: " + customerId + " " + getFullName();
    }
    
}
