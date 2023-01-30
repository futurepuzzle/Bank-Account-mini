/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccount;
import java.util.Scanner;
//all of these are for dealing with the file
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
/**
 * class for handling external files to be read by the main program
 * @author scr3w
 */
public class FileHandler {
    static Scanner fileReader;
    //creating a new bank account array for the file elements
    static BankAccount[] accounts;
    
    //method to get the data from the file as a string
    public static BankAccount[] getData (String fileName){
        //scanners can also read files
        try{
        //brings up topic of try catches (if there's a chance of something failing we want to try it, but also we want to catch it)
            //try opening the file, and if we can't we want to catch that error and throw a response
        fileReader = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException fnfe){
            //file not found exception
            System.out.println("File not found");
        }
        //can compund catches on top of each other
        //another catch for any other error
        //order of the catches matters here
        catch (Exception e){
            System.out.println("An unknown error has occurred");
        }
        
        //another try catch block to try and put the format of the bankaccount class elements
        //trying to push elements of file into the class
        try {
            //starts by getting the size of the file (# of elements)
            int size = fileReader.nextInt();
            accounts = new BankAccount[size];
            
            //make it go through line by line, index goes up by 1 for each line
            int index = 0;
            //using built-in hasNext() function
            while(fileReader.hasNext()){
                //reading each space on the line of the file and putting it into the class
                accounts[index] = new BankAccount(fileReader.nextInt(), new Customer(fileReader.nextInt(),fileReader.next(), fileReader.next(), fileReader.next().charAt(0)),
                fileReader.nextFloat(), new Date(fileReader.nextInt(), fileReader.nextInt(), fileReader.nextInt()));
                
                index++;
                
            }
        }
        catch(NoSuchElementException e){
            //this is for if the file is empty or if we somehow read past the end of the file
            System.out.println("File format error");
        }
        catch (IllegalStateException ise){
            //if the file was deleted or closed before we had a chance to read from it
            System.out.println("file reading error");
        }
        
        
        return accounts;
        
    }
}
