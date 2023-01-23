
package melbourneeats;

/**
 *
 * @author mattr
 */

import java.io.Serializable;

public class foodItems implements Serializable{
    
    private String foodItem;
    private String restaurantName; 
    private double foodItemCost;
    private double deliveryFee;
    private int quantity;
  
    
    
public foodItems(){
    
}    
    
public foodItems( String foodItem, String restaurantName, double foodItemCost){
    
    this.foodItem = foodItem;
    this.restaurantName = restaurantName;
    this.foodItemCost = foodItemCost;
}    

public foodItems( String foodItem, String restaurantName, double foodItemCost, double deliveryFee, int quantity){
    
    this.foodItem = foodItem;
    this.restaurantName = restaurantName;
    this.foodItemCost = foodItemCost;
    this.deliveryFee = deliveryFee;
    this.quantity = quantity;
}  


   public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

 

    public double getFoodItemCost() {
        return foodItemCost;
    }

    public void setFoodItemCost(double foodItemCost) {
        this.foodItemCost = foodItemCost;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "foodItems{" + "foodItem=" + foodItem + ", restaurantName=" + restaurantName + ", foodItemCost=" + foodItemCost + ", deliveryFee=" + deliveryFee + ", quantity=" + quantity + '}';
    }

    
   
  
    
}
