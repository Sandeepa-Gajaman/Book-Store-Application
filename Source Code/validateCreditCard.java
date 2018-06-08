/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

/**
 * validate credit card is subclass of a exception class
 * this class has constructor called validate credit card it will set the error message
 * and there is invalid message method it will return error message
 * @author ranul
 */
public class validateCreditCard extends Exception{
     private String message;
    public validateCreditCard ()
    {
       // System.out.println("Your credit card is not valid please try again!");
        message="Your card is invalid";
    }
    public String invalidMessage()
    {
    return message;
    }
}
