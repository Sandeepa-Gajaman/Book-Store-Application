/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;
import javax.swing.JOptionPane;

/**
 *
 * @author Ranul Deepanayake    10602053
 */
import java.util.Date;      //Required to set the date.
import java.text.*;
import java.util.Random;

public class Order{
    private int orderId;    //Set externally.
    private String date;    //Set internally.
    private int randomNumber;    //Set internally.
    private int employeeId; //Set externally.
    
    Date dateObject= new Date();

    public int getOrderId() {
        return orderId;
    }

    /**
     * Generates an order ID by using a date and a random number.
     */
    public void setOrderId() {//Create an order ID.
        String tempDate= date.replaceAll("/", "");
        int tempOrderId= Integer.parseInt(tempDate);
        this.orderId = tempOrderId+ randomNumber;
    }

    public String getDate() {
        return date;
    }

    /**
     * Generates the date of creating an order to be used in the order ID.
     */
    public void setDate() {
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        this.date = dateFormat.format(dateObject);
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * Generates a random number to be used in the order ID.
     */
    public void setRandomNumber() {
        Random random= new Random();
        randomNumber= random.nextInt(1000);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}