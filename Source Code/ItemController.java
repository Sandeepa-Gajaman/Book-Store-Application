/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;

/**
 *
 * @author HP
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class ItemController{
    private DbConnection connection;//rs reference to DbConnection. DbConnection act as a data type and DbConnection is a class
    private Item item= new Item();
    private DbView dbView = new DbView();//DbView object
    private ResultSet rs;//rs reference to ResultSet
    private ResultSetMetaData mdata;
    
    private int itemId;
    private String category;
    private String name;
    private float price;
    private int quantity;
    
    public ItemController(){
        connection= new DbConnection("jdbc:mysql://localhost:3306/bookstore?useSSL=false", "root", "");
        connection.InitializeConnection();  
    }
    
    //Add items
    public void setForm(String category, String name, float price, int quantity){
       this.category=category;
       this.name=name;
       this.price=price;
       this.quantity=quantity;
    }
    
    private void setVariables(){
        item.setItemCategory(category);
        item.setItemName(name);
        item.setUnitPrice(price);
        item.setQuantity(quantity);
    }
    
    public int insert(){
       setVariables();
       return item.insertItems(connection.getConnection());
    }
    
    
    //Remove Item
    public void setRemoveForm(int itemId){  
        this.itemId=itemId;
    }
    
    private void setRemove(){
        item.setItemId(itemId);
    }
    
    public int delete(){
        setRemove();
        return item.removeItems(connection.getConnection());
    }
    
    //Add quantity
    public void setQuantityForm(int quantity, int itemId){
        this.quantity=quantity;
        this.itemId=itemId;
    }
    
    private void setQuantity(){
        item.setQuantity(quantity);
        item.setItemId(itemId);
    }
    
    public int addQty(){
        setQuantity();
        return item.addQuantity(connection.getConnection());
    }
    
    //Remove Qty
    public void setRemoveQtyForm(int quantity, int itemId){
        this.quantity=quantity;
        this.itemId=itemId;
    }
    
    private void setRemoveQty(){
        item.setQuantity(quantity);
        item.setItemId(itemId);
    }
    
    public int removeQty(){
        try {
            setQuantity();
            return item.removeQuantity(connection.getConnection());
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    //get item table data
    public ResultSet setResult(){
       dbView.processResult(connection.getConnection(), "Select * from item");
       return dbView.getResultSet();
    }
    


}
