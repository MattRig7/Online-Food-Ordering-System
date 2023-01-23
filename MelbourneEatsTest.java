

package melbourneeats;

/**
 *
 * @author mattr
 */

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class MelbourneEatsTest {
    
    private foodItems foodItem;
    
    @Before
    public void setUp(){
        foodItem = new foodItems("French Fries" , "Burger King", 7.50, 5.00,5);
    }
    
    @After
    public void end(){
        foodItem = null;
    }
    
    
//    @Test
//    public void testMainMenu_CorrectMenuOption(){
//    
//    }  
//    
//    @Test
//    public void testMainMenu_InvalidInteger(){
//    
//    }
//   
//    @Test
//    public void testMainMenu_StringEntered(){
//    
//    }   
    
    
    @Test
    public void testAddQuantity_PositiveInteger(){
    foodItem.setQuantity(3);
    assertEquals(3, foodItem.getQuantity(), 5);
    }
    
    @Test
    public void testAddQuantity_NegativeInteger(){
    foodItem.setQuantity(-4);
    assertEquals(-4, foodItem.getQuantity(), 5); 
    }
    
    @Test
    public void testCalculateItemCost_CorrectDataTypes(){
    foodItem.getFoodItem();
    foodItem.getFoodItemCost();
    foodItem.getRestaurantName();
    foodItem.getDeliveryFee();
    foodItem.getQuantity();
    assertEquals("French Fries", foodItem.getFoodItem(), "French Fries"); 
    assertEquals(7.50, foodItem.getFoodItemCost(), 7.50); 
    assertEquals("Burger King", foodItem.getRestaurantName(), "Burger King");   
    assertEquals(5.00, foodItem.getDeliveryFee(), 5.00); 
    assertEquals(5, foodItem.getQuantity(), 5); 
    
    
    } 
    
    @Test
    public void testCalculateItemCost_WrongValues(){
    foodItem.getFoodItem();
    foodItem.getFoodItemCost();
    foodItem.getRestaurantName();
    foodItem.getDeliveryFee();
    foodItem.getQuantity();
    assertEquals("Cheese Burger", foodItem.getFoodItem(), "French Fries"); 
    assertEquals(10.50, foodItem.getFoodItemCost(), 7.50); 
    assertEquals("Holly Cow", foodItem.getRestaurantName(), "Burger King");   
    assertEquals(3.00, foodItem.getDeliveryFee(), 5.00); 
    assertEquals(8, foodItem.getQuantity(), 5); 
    
    
    } 
    
}
