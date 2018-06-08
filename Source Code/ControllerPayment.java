/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

/**
 *
 * @author ranul
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ControllerPayment
{
  
   private CashPayment cash;
   
   private float cashvalue;
   private float balance;
  /* private String creditcardnumber;
   private String debitcardnumber;*/
   private String CardType;
   private String CardNumber;
   private float totalAmount;
   private int orderId;


    public void setCardType(String CardType) {
        this.CardType = CardType;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

 
    public void setCashvalue(float cashvalue) {
        this.cashvalue = cashvalue;
    }
  /* 
   public void creditCardPayment()
   {
       creditcard=new CreditCard();
       creditcard.setcreditCard(creditcardnumber);
       try{
       creditcard.CardValidation();
       }
       catch(validateCreditCard e)
       {
           JOptionPane.showMessageDialog(null,e.invalidMessage());
       }
               
   }
   public void debitCardPayment()
   {
    debitcard=new DebitCard();   
    debitcard.setdebitCard(debitcardnumber);
    try{
       debitcard.CardValidation();
       }
       catch(validateCreditCard e)
       {
           JOptionPane.showMessageDialog(null,e.invalidMessage());
       }
   }*/
    public void cardPayment()
    {
       try {
           CardPayment obj=new CardPayment(); //create card payment object
           obj.setCardNumber(CardNumber);    //set card number
           obj.setTotalAmount(totalAmount);  //set total amount
           obj.setType(CardType);  //set card type
           obj.setOrderId(orderId); //set order id
           obj.CardValidation();  //call card validation which is in cardpayment
       } catch (validateCreditCard ex) {
           JOptionPane.showMessageDialog(null,ex.invalidMessage());
       }
    }
   public float cashPayment()
   {
       cash=new CashPayment(); 
       cash.setTotalAmount(totalAmount); //set total amount
       cash.setCash(cashvalue); //set cash
       cash.setOrderId(orderId);  //set order id
       try {
            cashvalue= cash.getBalance();
       } catch (ValidateCash ex) {
           JOptionPane.showMessageDialog(null,ex.invalidMessage());
           cashvalue=0;
       }
       finally
       {
           return  cashvalue;
       }
      
   }
   
   public void setTotalAmount(float value){
       this.totalAmount= value;
   }
   
   public void setOrderId(int value){
       this.orderId= value;
   }
   
}
