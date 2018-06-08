/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentMain;
/**
 * This class checks if the requested quantity for a particular item. 
 * @author Ranul Deepanayake 10602053
 */
public class ExceedsInventory extends Exception {
    
    public ExceedsInventory(){}
    
    public String getMessage(){
        return "Requested quantity is greater than available! Please select a "
                + "lower quantity!";
    }
}
