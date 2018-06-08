/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssignmentMain;

/**
 *
 * @author Lahiru
 */
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 * this will delete the record of a employee from employee table
 * @author ranul
 */
public class Delete {
     private static final String USERNAME="root";
      private static final String PASSWORD="";
      private static final String CONN_STRING="jdbc:mysql://localhost/bookstore";
      private static final  String SQL="delete from employee where nic =? ";
      
      private String nic;
      //this is constructor
      public Delete(String nic)
      {
          this.nic=nic;
          
      }

    
      
      
      public void delete() throws ClassNotFoundException
      {
            Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rst=null; //interface that will contain data returned from database
       Class.forName("com.mysql.jdbc.Driver");//load the driver class into memory
       try
       {
           System.out.println("Connecting to database...");
           con=DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
           stmt=  stmt=con.prepareStatement(SQL);
           
           stmt.setString(1, nic);
           int affected= stmt.executeUpdate();
           
           if(affected> 0)
           {
               System.out.println("deleted");
               JOptionPane.showMessageDialog(null, "Deleted");
                
               
            
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Not Deleted");
               System.out.println("not deleted");
           }
       }
      catch(SQLException e)
       {
           //System.err.println(e);
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
        }
      }
      

