
package melbourneeats;

/**
 *
 * @author mattr
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.HashMap;


public class MelbourneEats {
    
private FileInputStream fis;
private ObjectInputStream ois;    
ArrayList<String> discountList = new ArrayList<String>();

//java collection methods    
ArrayList<foodItems> foodList = new ArrayList<foodItems>(); //used to hold all menu items
HashSet<String> restaurantsOrdered = new HashSet<String>(); //used to check which restaurants are ordered from
HashMap<String, String> categoryList = new HashMap<String, String>(); //used to hold all categories
ArrayList<String> searchList = new ArrayList<String>(); //used to hold all eateries for search


//variables for search by restaurant
public String name = ""; 
public String lname = "";
public String searchText = "";

//variables used to calculate checkout method
double totalPrice = 0.0;
double deliveryFee = 0.0;
double deliveryFee2 = 0.0;
boolean orderFromDR = false;


  

 // method used to insert data into foodList arrayList
 public void populateLists(){
 
//array of all the food items in the restaurants file     
foodItems[] arrOfFoodItems = {new foodItems("Funky Burger", "Burger King",12.00, 5.00, 0),
    new foodItems( "French Fries" , "Burger King", 7.50, 5.00,0),
    new foodItems( "Coca Cola", "Burger King", 2.00, 5.00,0),
    new foodItems( "Chicken Wings", "Chicken King",4.50, 5.00,0),
    new foodItems( "Chicken Burger", "Chicken King",11.00, 5.00,0),
    new foodItems( "Orange Juice", "Chicken King",3.00, 5.00,0),
    new foodItems( "Tomato Juice", "Chicken King",3.50, 5.00,0),
    new foodItems( "Big Cheese Burger", "Holly Cow",14.00, 5.50,0),   
    new foodItems( "Satay Beef Burger", "Holly Cow", 13.00,5.50, 0),   
    new foodItems( "Ice Tea", "Holly Cow", 3.00,5.50, 0),   
    new foodItems( "Lobster Soup", "Moeders R.", 25.00, 10.00, 0),   
    new foodItems( "Fish of the Day", "Moeders R.", 22.00, 10.00,0),   
    new foodItems( "Mommy's Apple Pie", "Moeders R.", 8.00,10.00, 0),   
    new foodItems( "Irish Coffee", "Moeders R.", 4.50,10.00, 0),   
    new foodItems( "Caesar Salad", "Just Salads R.", 11.00, 6.00,0),   
    new foodItems( "Veggie Paradise", "Just Salads R.", 12.00,6.00, 0),   
    new foodItems( "Chick Peas Wrap", "Just Salads R.", 10.00, 6.00,0), 
    new foodItems( "Coconut Water", "Just Salads R.", 2.50, 6.00,0), 
    new foodItems( "Tiramisu", "Tea House", 8.00, 4.00,0), 
    new foodItems( "Chocolate Mousse", "Tea House", 7.50,4.00, 0), 
    new foodItems( "Bubble Tea", "Tea House", 4.50,4.00, 0), 
    new foodItems( "Green Tea", "Tea House", 3.50,4.00, 0), 
    
};

//cycles through array and adds items to list
 for(int i = 0; i < arrOfFoodItems.length; i++)
       foodList.add(arrOfFoodItems[i]);

 
 //array of all items categorised
 categoryList.put("Fast Food", "Burger King");
 categoryList.put("Fast Food", "Chicken King");
 categoryList.put("Fast Food", "Holly Cow");
 categoryList.put("Restaurant", "Moeders R.");
 categoryList.put("Restaurant", "Just Salads R.");
 categoryList.put("Cafe", "Tea House");
 
 //array for search algorithem 
 searchList.add("Burger King");
 searchList.add("Chicken King");
 searchList.add("Holly Cow");
 searchList.add("Moeders R.");
 searchList.add("Just Salads R.");
 searchList.add("Tea House");
 
 }
 
    
 //main method used to initiate the program
 // (runs the main menu and populate list methods)
    public static void main(String[] args) {
    MelbourneEats mb = new MelbourneEats(); 
    mb.populateLists();
  //  mb.readAllData();
    mb.mainMenu();
   
    }
    
    
    
    //main text interface that will be used by the customer to navigate the program
    public void mainMenu() {
        
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in); //initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions //used to catch execptions
          
      System.out.println("Welcome to Melbourne Eats!\n--------------------------------------------\n"
              + "> Select from main menu\n--------------------------------------------\n"+
              
      "1) Browse by category\n" +    
      "2) Search by restaurant\n"+              
      "3) Checkout\n"+       
      "4) Exit\n");
      
      try {
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          browseByCategory();
          break;
        case 2: // second option // first option // first option
          System.out.println("Please enter a restaurant name: ");  
          String name = userInput.next();         
          lname = name.toLowerCase(); 
          searchText = name;
       searchByRestaurant();
          break;
        case 3: // third option 
          checkout();
          break;
        case 4: // fourth option
          flag = false;
          System.exit(0);
          break;       
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }  
      
    } 
    catch(InputMismatchException e){
            System.out.println("That is not an integer, please try again." );
            flag = false;
            mainMenu();
    }
      }
  }    
 

    
    
  //////////////////////////////////////////////////////////////////////option 1
 public void browseByCategory() {
      
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in); //initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select by category\n--------------------------------------------\n"+
              
      "1) Restaurant\n" +    
      "2) Cafe\n"+              
      "3) Fast food\n"+       
      "4) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();  //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          restaurantsList();
          break;
        case 2: // second option // first option // first option
          cafeList();
          break;
        case 3: // third option
          fastFoodList();
          break;
        case 4: // fourth option
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");
      
  }   

      }
 }
 
 

 
 //////////////////////////////////////////////////////////////////////Restaurants List
 public void restaurantsList() {
      
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in); //initiates scanner to be used to get user's option             
      while (flag) { //used to catch execptions   
     System.out.println("\n--------------------------------------------\n"
              + "> Select from restaurant list\n--------------------------------------------\n"+
              
      "1) Moeders R. \n" +    
      "2) Just Salads R. \n"+                   
      "3) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          moedersR();
          break;
        case 2: // second option // first option // first option
          justSaladsR();
          break;
        case 3: // third option
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");
      
  }   
  
      }
 } 
 
 /*changes the quantity of an item if it is ordered
 For example:
 If the user would like to add a "Lobster Soup" to their order, every item they select that item the quantity in the...
 foodList array will be incremented by 1
 */
 public foodItems addQuantity(String item, int quantity){
     for (foodItems f: foodList){
         if (f.getFoodItem() == item){ //matches the item selected with the item in the array
             quantity = f.getQuantity(); //gets the current quantity of the item (initially 0)
             quantity ++; //increments that previous value
             f.setQuantity(quantity); //sets that newly incremented value
         }
        
     }
     return null;
 }
 
  //////////////////////////////////////////////////////////////////////Moeders R.
 public void moedersR() {
      
     String item = ""; //used to initialise item (String) which is used to collect value that the user has chosen
     int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select a food item from Moeders R.\n--------------------------------------------\n"+
              
      "1) Lobster Soup                 $25.00\n" +    
      "2) Fish of the Day              $22.00\n"+    
      "3) Mommy's Apple Pie             $8.00\n"+  
      "4) Irish Coffee                  $4.50\n"+        
      "5) No More\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option 
          item = "Lobster Soup";            
          addQuantity(item, quantity);
          break;    
        case 2: // second option // first option // first option
             item = "Fish of the Day";   
          addQuantity(item, quantity);
          break;
        case 3: // third option
         item = "Mommy's Apple Pie";   
          addQuantity(item, quantity);
          break;   
        case 4: // fourth option
        item = "Irish Coffee";   
          addQuantity(item, quantity);
          break;  
        case 5:
        //  System.out.println(order);  
          flag = false;  
          mainMenu();       
          break;            
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");
      
  }   
  
      }
 } 
 
 
  //////////////////////////////////////////////////////////////////////Just Salads R
 public void justSaladsR() {
      
     String item = ""; //used to initialise item (String) which is used to collect value that the user has chosen
     int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select a food item from Just Salads R.\n--------------------------------------------\n"+
              
      "1) Caeser Salad                 $11.00\n" +    
      "2) Veggie Paradise              $12.00\n"+    
      "3) Chick Peas Wrap              $10.00\n"+  
      "4) Coconut Water                 $2.50\n"+        
      "5) No More\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
              item = "Caeser Salad";   
          addQuantity(item, quantity);
          break;
        case 2: // second option // first option // first option
             item = "Veggie Paradise";   
          addQuantity(item, quantity);
          break;
        case 3: // third option
           item = "Chick Peas Wrap";   
          addQuantity(item, quantity);
          break;  
        case 4: // fourth option
           item = "Coconut Water";   
          addQuantity(item, quantity);
          break;  
        case 5:
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");     
  }   
      }
 } 
 
 
 
 
 //////////////////////////////////////////////////////////////////////Cafe List
 public void cafeList() {
      
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select from cafe list\n--------------------------------------------\n"+
              
      "1) Tea House\n" +                     
      "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          teaHouse();
          break;
        case 2: // second option // first option // first option
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");
      
  }   
  
      }
 } 
 
 
   //////////////////////////////////////////////////////////////////////Tea House
 public void teaHouse() {
      
     String item = ""; //used to initialise item (String) which is used to collect value that the user has chosen
     int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered //used to initialise quantity (int), which is used to change the quantity of number of items ordered
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select a food item from Tea House\n--------------------------------------------\n"+
              
      "1) Tiramisu                      $8.00\n" +    
      "2) Chocolate Mousse              $7.50\n"+    
      "3) Bubble Tea                    $4.50\n"+  
      "4) Green Tea                     $3.50\n"+        
      "5) No More\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
             item = "Tiramisu";   
          addQuantity(item, quantity);
          break;
        case 2: // second option // first option // first option
           item = "Chocolate Mousse";   
          addQuantity(item, quantity);
          break;
        case 3: // third option
          item = "Bubble Tea";   
          addQuantity(item, quantity);
          break;  
        case 4: // fourth option
           item = "Green Tea";   
          addQuantity(item, quantity);
          break;  
        case 5:
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");     
  }   
      }
 } 
 
 
 //////////////////////////////////////////////////////////////////////Fast Food List
 public void fastFoodList() {
      
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select from fast food list\n--------------------------------------------\n"+
              
      "1) Burger King\n" +
      "2) Chicken King\n" + 
      "3) Holly Cow\n" +          
      "4) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt(); //gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          burgerKing();
          break;
        case 2: // second option // first option // first option
          chickenKing();
          break; 
        case 3: // third option
          hollyCow();
          break;
        case 4: // fourth option
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");
      
  }   
  
      }
 }  
 

   //////////////////////////////////////////////////////////////////////Burger King
 public void burgerKing() {
      
     String item = ""; //used to initialise item (String) which is used to collect value that the user has chosen
     int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select a food item from Burger King\n--------------------------------------------\n"+
              
      "1) Funky Burger                 $12.00\n" +    
      "2) French Fries                  $7.50\n"+    
      "3) Coca Cola                     $2.00\n"+        
      "4) No More\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
             item = "Funky Burger";   
          addQuantity(item, quantity);
          break;
        case 2: // second option // first option // first option
               item = "French Fries";   
          addQuantity(item, quantity);
          break;
        case 3: // third option
            item = "Coca Cola";   
          addQuantity(item, quantity);
          break;  
        case 4: // fourth option
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");     
  }   
      }
 }  

 //////////////////////////////////////////////////////////////////////Chicken King
 public void chickenKing() {
      
     String item = ""; //used to initialise item (String) which is used to collect value that the user has chosen
     int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select a food item from Chicken King\n--------------------------------------------\n"+
              
      "1) Chicken Wings                 $4.50\n" +    
      "2) Chicken Burger               $11.00\n"+    
      "3) Orange Juice                  $3.00\n"+       
      "4) Tomato Juice                  $3.50\n"+           
      "5) No More\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
            item = "Chicken Wings";   
          addQuantity(item, quantity);
          break;
        case 2: // second option // first option // first option
          item = "Chicken Burger";   
          addQuantity(item, quantity);
          break;
        case 3: // third option
             item = "Orange Juice";   
          addQuantity(item, quantity);
          break;  
        case 4: // fourth option
             item = "Tomato Juice";   
          addQuantity(item, quantity);
          break;    
        case 5:
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");     
  }   
      }
 }  
 
 //////////////////////////////////////////////////////////////////////Holly Cow
 public void hollyCow() {
      
     String item = ""; //used to initialise item (String) which is used to collect value that the user has chosen
     int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
      while (flag) { //used to catch execptions
     
     System.out.println("\n--------------------------------------------\n"
              + "> Select a food item from Holly Cow\n--------------------------------------------\n"+
              
      "1) Big Cheese Burger            $14.00\n" +    
      "2) Satay Beef Burger            $11.00\n"+    
      "3) Ice Tea                       $3.00\n"+       
      "4) No More\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
           item = "Big Cheese Burger";   
          addQuantity(item, quantity);
          break;
        case 2: // second option // first option // first option
           item = "Satay Beef Burger";   
          addQuantity(item, quantity);
          break;
        case 3: // third option
           item = "Ice Tea";   
          addQuantity(item, quantity);
          break;   
        case 4: // fourth option
          mainMenu();
          break;  
          default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid option");     
  }   
      }
 }   
 

 
  public void searchByRestaurant() {
        

     for (foodItems f: foodList){
         if (f.getRestaurantName() == name) {
              System.out.println(f);
         }
     }
     System.out.println(foodList.contains(name));
     
//     if (searchList.contains(name)){
//          System.out.println("\n--------------------------------------------\n"
//              + "> Select from matching list\n--------------------------------------------\n");
//          
//          
//     }
     
      boolean flag = true; //syntax error check, if wrong input is entered the program will not crash
      Scanner userInput = new Scanner(System.in);//initiates scanner to be used to get user's option
       System.out.println("\n--------------------------------------------\n"
              + "> Select from matching list\n--------------------------------------------\n");
      while (flag) { //used to catch execptions
      System.out.println(lname);
      switch (lname){
          case "burger":
          System.out.println(
          "1) Burger King\n"+                    
          "2) Go to main menu\n");
          
          
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          burgerKing();
          break;
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
      switch (lname){
          case "chicken":
          System.out.println(
          "1) Chicken King\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          chickenKing();
          break;
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
        switch (lname){
          case "king":
          System.out.println(
          "1) Burger King\n"+  
          "2) Chicken King\n"+                   
          "3) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          burgerKing();
          break;
        case 2: // second option // first option // first option
          chickenKing();
          break;  
        case 3: // third option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
        
        
      switch (lname){
          case "holly":
          System.out.println(
          "1) Holly Cow\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          hollyCow();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
      
       switch (lname){
         case "cow":
          System.out.println(
          "1) Holly Cow\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          hollyCow();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
     
       switch (lname){
         case "moeders":
          System.out.println(
          "1) Moeders R.\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          moedersR();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }  
 
       switch (lname){
         case "r":
          System.out.println(
          "1) Moeders R.\n"+ 
          "1) Just Salads R.\n"+          
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          moedersR();
          break; 
        case 2: // second option // first option // first option
          justSaladsR();
          break;    
        case 3: // third option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
       
       switch (lname){
         case "just":
          System.out.println(
          "1) Just Salads R.\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          justSaladsR();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }         
       
       switch (lname){
         case "salads":
          System.out.println(
          "1) Just Salads R.\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          justSaladsR();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }   

       switch (lname){
         case "tea":
          System.out.println(
          "1) Tea House\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          teaHouse();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      } 

       switch (lname){
         case "house":
          System.out.println(
          "1) Tea House\n"+                    
          "2) Go to main menu\n");
      
      System.out.print("Please select: "); //asks user for input
      int option = userInput.nextInt();//gets number imput from the user for selection
      userInput.nextLine();
      switch (option) { //switch statement for user selection
        case 1: // first option
          teaHouse();
          break;  
        case 2: // second option // first option // first option
          mainMenu();
          break;  
        default: //catches the user if they enter a wrong option
          System.out.println("Please select a valid menu option");
        }        
      }
       break;  
     
    
    } 
  }    
 
  //used to get values from the foodList arraylist so values can be printed at checkout
   public foodItems calculateItemCost(String findName, String name, double price,  int quantity) {
 
     for (foodItems f:foodList){
      if (f.getRestaurantName() == findName){ //checks the restaurant name value
           if (f.getQuantity() >= 1){ //only runs if an item has been ordered (ordered at least once)
               
           //array items are pulled and assigned to variables    
           name = f.getFoodItem();
           price = f.getFoodItemCost();                 
           quantity = f.getQuantity();     
           deliveryFee2 = f.getDeliveryFee();
           restaurantsOrdered.add(findName);           
           double itemTotal = quantity * price; //calculation for the total     
           totalPrice = totalPrice + itemTotal;
           System.out.println("  " +quantity + " " + name + "    $"  + itemTotal ); //how the program prints the items ordered
           
           }
      }
  }
    return null;
  }
 
public void checkout() {
         
System.out.println("\n--------------------------------------------\n"
              + "> You have ordered the following items\n--------------------------------------------\n");

//values used to store and print final calculations       
String findName = "";    
String name = "";
double price = 0.0;
int quantity = 0; //used to initialise quantity (int), which is used to change the quantity of number of items ordered



findName = "Burger King";
System.out.println(findName);
calculateItemCost(findName, name, price, quantity); //runs the calculation to get all the values of the items ordered and prints them
System.out.println("Delivery Fee:  $5.00");
           System.out.println("-----------------------------------------------------"); 

if (restaurantsOrdered.contains(findName)){ //checks to see if any items have been ordered from this restaurant by checking the "restaurantsOrdered" array
           deliveryFee = deliveryFee + deliveryFee2;
               orderFromDR = true;     
           }

           
           
findName = "Chicken King";
System.out.println(findName);
calculateItemCost(findName, name, price,  quantity); //runs the calculation to get all the values of the items ordered and prints them
System.out.println("Delivery Fee:  $5.00");
           System.out.println("-----------------------------------------------------"); 

if (restaurantsOrdered.contains(findName)){ //checks to see if any items have been ordered from this restaurant by checking the "restaurantsOrdered" array
           deliveryFee = deliveryFee + deliveryFee2;
               orderFromDR = true;     
           }      
           
findName = "Holly Cow";
System.out.println(findName);
calculateItemCost(findName, name, price,  quantity); //runs the calculation to get all the values of the items ordered and prints them
System.out.println("Delivery Fee:  $5.50");

           System.out.println("-----------------------------------------------------"); 

if (restaurantsOrdered.contains(findName)){ //checks to see if any items have been ordered from this restaurant by checking the "restaurantsOrdered" array
           deliveryFee = deliveryFee + deliveryFee2;
               orderFromDR = true;     
           }       
           
findName = "Moeders R.";
System.out.println(findName);
calculateItemCost(findName, name, price,  quantity); //runs the calculation to get all the values of the items ordered and prints them
System.out.println("Delivery Fee:  $10.00");

           System.out.println("-----------------------------------------------------"); 

if (restaurantsOrdered.contains(findName)){ //checks to see if any items have been ordered from this restaurant by checking the "restaurantsOrdered" array
           deliveryFee = deliveryFee + deliveryFee2;
               orderFromDR = true;     
           }       
           
findName = "Just Salads R.";
System.out.println(findName);
calculateItemCost(findName, name, price,  quantity); //runs the calculation to get all the values of the items ordered and prints them
System.out.println("Delivery Fee:  $6.00");

           System.out.println("-----------------------------------------------------"); 

if (restaurantsOrdered.contains(findName)){ //checks to see if any items have been ordered from this restaurant by checking the "restaurantsOrdered" array
           deliveryFee = deliveryFee + deliveryFee2;
               orderFromDR = true;     
           }         
           
findName = "Tea House";
System.out.println(findName);
calculateItemCost(findName, name, price,  quantity); //runs the calculation to get all the values of the items ordered and prints them
System.out.println("Delivery Fee:  $4.00");

           System.out.println("-----------------------------------------------------"); 

if (restaurantsOrdered.contains(findName)){ //checks to see if any items have been ordered from this restaurant by checking the "restaurantsOrdered" array
           deliveryFee = deliveryFee + deliveryFee2;
               orderFromDR = true;     
           }
           
           
 
           
  //variables used to calculate the discounts of the order
  Double total = 0.0;
  Double discount = 0.0;
  Double discountedTotal = 0.0;
  
  //if the price is more than $10 and less than $20 there is a 10% discount
  if ((totalPrice >= 10.00) & (totalPrice < 20.00 )){
      discount = totalPrice*0.10; //gets the discount of the total value
      discountedTotal = totalPrice-discount; //subtracts the discount from the total
  }
  //if the price is more than $20 and less than $30 there is a 15% discount
  else if ((totalPrice >= 20.00) & (totalPrice < 30.00 )){
      discount = totalPrice*0.15; //gets the discount of the total value
      discountedTotal = totalPrice-discount; //subtracts the discount from the total
  }
  //if the price is more than $30 there is a 20% discount
  else if ((totalPrice >= 30.00)){
      discount = totalPrice*0.20; //gets the discount of the total value
      discountedTotal = totalPrice-discount; //subtracts the discount from the total
  }
  
  
  //checks to see if more than one restaurant was ordered from
  if (orderFromDR = true){
      deliveryFee = deliveryFee*0.5; //halfs the delivery fee if value is true
  }
  
  
  DecimalFormat df = new DecimalFormat(); //new decimal format
  df.setMaximumFractionDigits(3); //decimal format to show values
  
  
  //displays final values of order
  System.out.println("-----------------------------------------------------");
  System.out.println("Order Price:                   $" + df.format(discountedTotal) );
  System.out.println("Delivery fee:                  $"  + df.format(deliveryFee));  
  System.out.println("You have saved:                $" + df.format(discount) );
  System.out.println("Total amount to pay:           $"  + df.format((discountedTotal+deliveryFee)));

}





//insert data into arrayList from file
public void readAllData() { 
   foodList.clear();
   discountList.clear();
   
   /////////////////////////////////////////////Restaurants
    try {
      fis = new FileInputStream("Restaurants.txt");
      ois = new ObjectInputStream(fis);
      
      while (true) {
        try {
        Object obj = ois.readObject();
        //cast to foodItems
        foodItems f = (foodItems)obj;
         //add to list
        foodList.add(f);
          
        } catch (EOFException eof) {
          fis.close();
          ois.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    /////////////////////////////////////////////Discounts
  try {
      fis = new FileInputStream("Discounts.txt");
      ois = new ObjectInputStream(fis);
      
      while (true) {
        try {
        Object obj = ois.readObject();
        //cast to foodItems
        foodItems f = (foodItems)obj;
         //add to list
        foodList.add(f);
          
        } catch (EOFException eof) {
          fis.close();
          ois.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
}

}