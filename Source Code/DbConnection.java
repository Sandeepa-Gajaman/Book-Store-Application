/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ranul Deepanayake    10602053
 */
public class DbConnection {
    private Connection connection;
    private String host;
    //"jdbc:mysql://localhost:3306/bookstore?useSSL=false";
    private String userName;
    private String password;
    
    /**
     * Initializes the connection parameters.
     * @param host
     * @param userName
     * @param password 
     */
    public DbConnection(String host, String userName, String password){
        this.host= host;
        this.userName= userName;
        this.password= password;
    }
    
    /**
     * @return Returns 1 on connection success and 0 on failure.
     */
    public int InitializeConnection(){
        int result= 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(host, userName, password);
            result= 1;
        }
        catch(ClassNotFoundException e){
            System.out.println("JDBC classes not found!");
            JOptionPane.showMessageDialog(null, "JDBC classes not found!");
        }
        catch(Exception e){
            System.out.println("Unable to establish a connection to the server! Please check network configuration!");
               JOptionPane.showMessageDialog(null, "Unable to establish a connection to the server! Please check network configuration!");
        }
        finally{
            try{
               
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{
                return result;
            }
        }
    }
    
    /**
     * Returns a created Connection object. 
     * @return Returns an object of the Connection type.
     */
    public Connection getConnection(){
        return connection;
    }
}
