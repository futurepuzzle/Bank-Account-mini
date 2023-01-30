/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;

/**
 *
 * @author scr3w
 */
public class Date {

    //normally we would create this class first then create the bankaccount class
    private int month;
    private int day;
    private int year;

    //default constructor
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1;
    }

    //main constructor
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //get getters set setters
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        //this.month = month;
        if (month > 0 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Invalid month!");
            this.month = 1;
        }
    }

    public void setDay(int day) {
        //check to see if it is a valid day in a month
        //zero is placed so that the 0th element will be ignored
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && day == 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            this.day = day;
        }
        else if ( day<1 || day > days[month] ){
            this.day = 1;
        }
        else {
            this.day = day;
        }
    }

    public void setYear(int year) {
        this.year = year;
    }

    //method that converts all elements to strings
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    
    

}
