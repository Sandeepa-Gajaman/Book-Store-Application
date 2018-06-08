/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

import javax.swing.JOptionPane;

/**
 *
 * @author ranul
 */
public class CardPayment extends Payment implements BankService{
   private String CardNumber;
   private  String type;


    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTotalAmount(float value){
        this.Totalamount= value;
    }
    
   public  void CardValidation()throws validateCreditCard 
   {
       
    if(CardNumber.length()!=10) //if card length is not equal to 10 throw validate exception
    { 
        throw new validateCreditCard();
    }
    else
    {
        //System.out.println("Proceed!");
         JOptionPane.showMessageDialog(null,"validated successfully");
         transferFund();
    }
       
   }

   
    @Override
    public void transferFund() {
        JOptionPane.showMessageDialog(null, "Funds successfully transfered!");
        insertIntoPayment();  
    }

   public void setOrderId(int value){
       this.orderId= value;
   }
   /**
     * create connection object and pass the  connection string
     * initialize the connection
     * get the initialized connection object
     */
   private void insertIntoPayment(){
       DbConnection connection= new DbConnection("jdbc:mysql://localhost:3306/bookstore?useSSL=false", "root", "");
       connection.InitializeConnection();
       PaymentInsert paymentInsert= new PaymentInsert();
       paymentInsert.insert(connection.getConnection(), orderId, type, Totalamount);
   }
     
}

