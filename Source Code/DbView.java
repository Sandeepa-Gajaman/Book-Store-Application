/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ranul Deepanayake    10602053
 */
public class DbView {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private String host, userName, password;
    
    public DbView(){}
    
    /**
     * Executes a select query and creates a ResultSet object with the returned
     * query result.
     * @param connection Pass the connection object as an argument. 
     * @param query Pass a select query as an argument.
     * @return Returns 1 on successful query execution or 0 on failure. 
     */
    public int processResult(Connection connection, String query){
        this.connection= connection;
        int result= 0;
        try{
            statement= connection.createStatement();
            resultSet= statement.executeQuery(query);
            metaData= resultSet.getMetaData();
            result= 1;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                //connection.close();
            }
            catch(Exception e){
                System.out.println("");
            }
            finally{
                return result;
            }
        }
    }
    
    public int processResult(String query){
        defaultConnection();
        int result= 0;
        try{
            statement= connection.createStatement();
            resultSet= statement.executeQuery(query);
            metaData= resultSet.getMetaData();
            result= 1;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                //connection.close();
            }
            catch(Exception e){
                System.out.println("");
            }
            finally{
                return result;
            }
        }
    }
    
    public int processResult(String host, String userName, String password, String query){
        this.host= host;
        this.userName= userName;
        this.password= password;
        setConnection();
        int result= 0;
        try{
            statement= connection.createStatement();
            resultSet= statement.executeQuery(query);
            metaData= resultSet.getMetaData();
            result= 1;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                //connection.close();
            }
            catch(Exception e){
                System.out.println("");
            }
            finally{
                return result;
            }
        }
    }
    
    /**
     * Sets a connection object.
     */
    private void setConnection(){
        DbConnection con= new DbConnection(host, userName, password);
        con.InitializeConnection();
        connection= con.getConnection();
    }
    
    /**
     * Sets a default connection.
     */
    private void defaultConnection(){
        DbConnection con= new DbConnection("jdbc:mysql://localhost:3306/bookstore?useSSL=false", "root", "");
        con.InitializeConnection();
        connection= con.getConnection();
    }
    
    public ResultSet getResultSet(){
        return resultSet;
    }
    
    public ResultSetMetaData getMetaData(){
        return metaData;
    }
}
