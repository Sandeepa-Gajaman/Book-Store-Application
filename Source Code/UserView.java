/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssignmentMain;
import javax.swing.JOptionPane;
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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class UserView {
     private static final String USERNAME="root";
      private static final String PASSWORD="";
      private static final String CONN_STRING="jdbc:mysql://localhost/bookstore";
        ArrayList<TableClass> list=new ArrayList(); //create arraylist and tableclass is user defined data type (user define class)
 //this will select the all the details
      public void show() throws ClassNotFoundException, SQLException{
       Connection con=null;
        Statement stmt=null;
        ResultSet rst=null; //interface that will contain data returned from database
       Class.forName("com.mysql.jdbc.Driver");//load the driver class into memory
     
       try{
            

      //connection
      System.out.println("Connecting to database...");
      con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
      stmt=(Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      //stmt.setMaxRows(5);
      rst=stmt.executeQuery("select * from employee");
     // rst.last();//move cursor to last raw
      //System.out.println("Number of Rows "+rst.getRow());
      while(rst.next())
      {
          String empid=rst.getString("empId");
          String fname=rst.getString("fName");
          String lname=rst.getString("lName");
          String contactnumber=rst.getString("contactNumber");
          String address=rst.getString("address");
          String nic=rst.getString("nic");
          
          System.out.print("ID = "+empid+" ");
          System.out.print("NAME = "+fname+" ");
          System.out.print("Lname = "+lname+" ");
          System.out.print("contactnumber = "+contactnumber+" ");
          System.out.print("address = "+address+" ");
          System.out.print("nic = "+nic+" ");
          System.out.println("");
          /*
          create object from table class and assigned to list
          */
          TableClass obj =new TableClass(empid,fname,lname,contactnumber,address,nic);
          list.add(obj);
          
      }
      
      
        }
        catch(SQLException e)
        {
            //System.err.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
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
      /*
      return the list
      */
      public ArrayList<TableClass> shows()
      {
          ArrayList<TableClass> lists=list;
         // DefaultTableModel model=jTable1.getModel();
          //EmployeeAddRemove object=new EmployeeAddRemove();
         return lists;
          
      }
      
}
