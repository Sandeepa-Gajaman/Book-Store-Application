/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Udara
 * this class is an abstract class on all the Items
 */
public class Item {
  private int itemId;    
  private String itemCategory;
  private float unitPrice;
  private String itemName;
  private int quantity;
  
   
   private PreparedStatement preparedStatement;
   
   //Inser items
   public int insertItems (Connection connection)
    {
       int result = 0;
       String sql = "INSERT INTO item (itemCategory,itemName,quantity,unitPrice) VALUES (?,?,?,?)";
       
       try
       {
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, itemCategory);
           preparedStatement.setString(2, itemName);
           preparedStatement.setInt(3, quantity);
           preparedStatement.setFloat(4, unitPrice);
           
           preparedStatement.executeUpdate();
           result = 1;
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
   
   
   //Add Qty   
   public int addQuantity(Connection connection){
        int result= 0;
        try{
            preparedStatement= connection.prepareStatement("update item set quantity = quantity+? where itemId= ?");//Adding Qty to DB
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
   
   //Remove Qty
   public int removeQuantity(Connection connection){
        int result= 0;
        try{
            preparedStatement= connection.prepareStatement("update item set quantity = quantity-? where itemId= ?");//Removing Qty to DB
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
   
  //Remove Items 
  public int removeItems (Connection connection)
    {
       int result = 0;
       String delquery = "delete from item where itemId = ?";
       
       try
       {
           preparedStatement = connection.prepareStatement(delquery);
           preparedStatement.setInt(1,itemId);
           preparedStatement.executeUpdate();
           result = 1;
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
  
  
  

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
