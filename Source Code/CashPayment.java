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
public class CashPayment extends Payment {
    
   private float balance;
   private float cash;

   /* @Override
    
    public String generateId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public float getBalance() throws ValidateCash {
        balance= cash-Totalamount;
        if(balance<0) //throw exception when balance less than zero
        {
            throw new ValidateCash();
        }
      
        else
        {
            insertIntoPayment();
            return balance;
        }
    }

    public void setCash(float cash) {
        this.cash = cash;
    }
    
    public void setTotalAmount(float value){
        this.Totalamount= value;
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
       paymentInsert.insert(connection.getConnection(), orderId, "Cash", Totalamount);
   }
}
