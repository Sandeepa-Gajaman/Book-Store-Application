/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * connection includes connection object 
 * this will send the payment details to the payment table(order id,total price,payment method)
 * @author ranul
 */

public class PaymentInsert {
    private PreparedStatement preparedStatement;
    
    public void insert(Connection connection, int orderId, String paymentMethod, float totalPrice){
        try{
            preparedStatement= connection.prepareStatement("Insert into payment (orderId, totalPrice, paymentMethod)"
                    + "values (?, ?, ?)");
            preparedStatement.setInt(1, orderId);
            preparedStatement.setFloat(2, totalPrice);
            preparedStatement.setString(3, paymentMethod);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Payment successfull!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error inserting record into database!");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            try{
                connection.close();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in closing  database connection!");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
