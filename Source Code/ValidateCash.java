/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

/**
 * validate cash is a subclass of a exception class this class has constructor called validate cash it will
 * set the error message and there is invalid message method it will return error message
 * @author shama
 */
public class ValidateCash extends Exception {
    private String message;
    public ValidateCash ()
    {
       // System.out.println("Your credit card is not valid please try again!");
        message="Not sufficient amount";
    }
    public String invalidMessage()
    {
    return message;
    }
}
