/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;
import java.util.ArrayList;
/**
 *
 * @author Ranul Deepanayake    10602053
 */
public class OrderItem {
    private ArrayList itemId= new ArrayList();
    private ArrayList itemName= new ArrayList();
    private ArrayList itemCategory= new ArrayList();
    private ArrayList itemUnitPrice= new ArrayList();
    private ArrayList itemQuantity= new ArrayList();
    float totalPrice= 0;

    public ArrayList getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId.add(itemId);
    }

    public ArrayList getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.add(itemName);
    }

    public ArrayList getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory.add(itemCategory);
    }

    public ArrayList getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(float itemUnitPrice) {
        this.itemUnitPrice.add(itemUnitPrice);
    }

    public ArrayList getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity.add(itemQuantity);
    }
    
    public float getTotalPrice(){
        return totalPrice;
    }
    
    public void resetTotalPrice(){
        totalPrice= 0;
    }
    
    /**
    Processes the total price by taking the values stored in the array lists.
    */
    public void processTotalPrice(){
        float tempUnitPrice;
        int tempQuantity;
        for(int i=0; i< itemId.size(); i++){
            tempUnitPrice= Float.parseFloat(itemUnitPrice.get(i).toString());
            tempQuantity= Integer.parseInt(itemQuantity.get(i).toString());
            totalPrice= totalPrice+ (tempUnitPrice* tempQuantity);
            System.out.println(tempUnitPrice+ " "+ tempQuantity);
        }
    }
}
