/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * This class acts as the controller according to the MVC architecture. 
 * @author Ranul Deepanayake    10602053
 */
public class Controller {
    //Instatiate an object from the item class in here and use it throught this class.
    private DbConnection connection;
    private DbView view;
    private String searchTerm;
    private String selectedValue;
    private String[] selectedValueArray;
    private Order order;
    private OrderItem orderItem;
    private int itemQuantity; //Number of units added to the cart.
    
    private float totalPrice;
    
    public Controller(){
        connection= new DbConnection("jdbc:mysql://localhost:3306/bookstore?useSSL=false", "root", "");
        view= new DbView();
        orderItem= new OrderItem();
        order= new Order();
        order.setDate();    //Initialize date and time for the order.
        order.setRandomNumber();
        order.setOrderId();
        System.out.println(order.getOrderId());
        connection.InitializeConnection();
    }
    
    public void setSearchTerm(String value){
        connection.InitializeConnection();    //Will continously check for database connection errors.
        this.searchTerm= "Select * from item where itemName like '%"+ value+ "%'";
    }
    
    /**
     * Returns a ResultSet object for a given search term (item).
     * @return 
     */
    public ResultSet getSearchResult(){
        view.processResult(connection.getConnection(), searchTerm);
        return view.getResultSet();
    }
    
    public ResultSetMetaData getSearchResultMetaData(){
        return view.getMetaData();
    }
    
    public void setSelectedValue(String value){
        this.selectedValue= value;
    }
    
    public String[] getSelectedValueArray(){
        selectedValueArray= selectedValue.split("(\\s){10}", 5);
        return selectedValueArray;
    }
    
    public void setItemQuantity(int value){
        this.itemQuantity= value;
    }
    
    /**
     * Passes the components of a selected item by the user to the orderItem class. 
     */
    public void insertToOrder(){
        int itemId, itemQuantity;
        String itemName, itemCategory;
        float itemUnitPrice;
        
        itemId= Integer.parseInt(selectedValueArray[0]);
        itemName= selectedValueArray[1];
        itemCategory= selectedValueArray[2];
        itemUnitPrice= Float.parseFloat(selectedValueArray[3]);
        itemQuantity= this.itemQuantity; //Set the quantity selected per item (taken from the form).
        
        orderItem.setItemId(itemId);
        orderItem.setItemName(itemName);
        orderItem.setItemUnitPrice(itemUnitPrice);
        orderItem.setItemQuantity(itemQuantity);
    }
    
    /**
     * Gets the total price for the added items in the cart from the itemOrder class.
     * @return Returns the calculated total price. 
     */
    public float getTotalPrice(){
        orderItem.resetTotalPrice();
        orderItem.processTotalPrice();
        //System.out.println(orderItem.getTotalPrice());
        return orderItem.getTotalPrice();
    }
    
    /**
     * Checks whether the quantity requested is greater than the quantity available of a certain item.
     * @param quantityRequested The quantity requested by the user.
     * @param quantityAvailable The quantity available in the inventory.
     * @throws ExceedsInventory 
     */
    public void checkQuantity(int quantityRequested, int quantityAvailable)throws ExceedsInventory{
        if(quantityRequested> quantityAvailable){
            throw new ExceedsInventory();
        }
    }
    
    public int getOrderId(){
        return order.getOrderId();
    }
}
