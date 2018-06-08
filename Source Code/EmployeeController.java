/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AssignmentMain;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import bookshop.employee.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmployeeController {
    
 
    private String fName;
    private String lName;
    private String contactNumber;
    private String address;
    private String nic;

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNic(String nic) {
        this.nic = nic;
       
    }
    
   /* public EmployeeController(String fName,String lName,String contactNumber,String address,String nic)
    {
        fName=fName;
        lName=lName;
        contactNumber=contactNumber;
        address=address;
        nic=nic;
       
    }*/
    public void call() 
    {
        //create object from databse class and pass fname,lname,contactnumber,nic,address as parameters
        Database obj=new Database(fName,lName,contactNumber,address,nic);
        try{
        obj.insert(); //call insert method
        }
        catch(SQLException e)
        {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void del()
    {  //create object from databse class and pass nic
        try {
            Delete obj=new Delete(nic);
            obj.delete(); //call delete method
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
