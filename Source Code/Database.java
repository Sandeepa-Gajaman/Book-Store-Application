/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssignmentMain;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {
        private String fName;
        private String lName;
        private String contactNumber;
        private String address;
        private String nic;
//this is a constructor 
    public Database(String fName, String lName, String contactNumber, String address, String nic) {
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
        this.address = address;
        this.nic = nic;
    }
        
     private static final String USERNAME="root";
      private static final String PASSWORD="";
      private static final String CONN_STRING="jdbc:mysql://localhost/bookstore";
      private static final  String SQL="INSERT INTO employee(fName,lName,contactNumber,address,nic) VALUES(?,?,?,?,?)";
      /**
       * insert function insert first name,last name,contact number,address,identity card number to employee table 
       * @throws ClassNotFoundException
       * @throws SQLException 
       */
      public void insert() throws ClassNotFoundException, SQLException 
      {
          Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rst=null; //interface that will contain data returned from database
       Class.forName("com.mysql.jdbc.Driver");//load the driver class into memory
      
     
        try{
            

      //connection
         // System.out.println("Connecting to database...");
      con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
   
         stmt=con.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
   
        stmt.setString(1,fName);
        stmt.setString(2,lName);
        stmt.setString(3,contactNumber);
        stmt.setString(4,address);
        stmt.setString(5,nic);
      int affected=stmt.executeUpdate();
      if(affected==1)
      {
          
          JOptionPane.showMessageDialog(null, "record insert successfully");
         /* rst=stmt.getGeneratedKeys();
          rst.next();
          int ID=rst.getInt(1);*/

      }
     else
      {
           JOptionPane.showMessageDialog(null, "not stored");
      }
     
      
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
       finally
        {
            if(rst!=null)
            {
                rst.close();
            }
            if(stmt!=null)
            {
                stmt.close();
            }
            
            if(con!=null)
            {
                con.close();
            }
        }
      }
}
