/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ranul
 */
public class ItemUpdate {
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    /**
     * Updates the item quantity.
     * @param connection Sets the connection object as an argument.
     * @param studentId Sets the student ID of the student to be changed.
     * @param name Sets the new value for the name column.
     * @return Returns 1 on successful query execution or 0 on failure.
     */
    public int updateItemQuantity(Connection connection, int quantity, int itemId){
        int result= 0;
        try{
            preparedStatement= connection.prepareStatement("update item set quantity= ? where itemId= ?");
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, itemId);
            preparedStatement.executeUpdate();
            result= 1;
        }
        catch(SQLException e){
            System.out.println("Error! Could not update inventory! "+ e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            return result;      
        }
    }
}
