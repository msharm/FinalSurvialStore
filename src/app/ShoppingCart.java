package app;


import java.util.*;

import utilities.Displayer;


/**
 * 
 * @author Reed
 */
public class ShoppingCart {
	/*
	 * create users shopping cart to hold products
	 * total number of products in users shopping cart
	 */
	public List<Product> shoppingCartList = new ArrayList<>();
	private int productsInCart = 0;
	
	/**
	 * matches user input with shopping cart option(app functionality)
	 * @param wareHouse
	 */
	public void selectShoppingCartMenuOp(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
	    displaysShoppingCartMenuOptions();
	    
	    do{
	       choice = scanner.nextInt();
	       
	       switch (choice) {
	       		case 1:
	       			selectShoppingCartMenuCase1(shoppingCart);
	                break;
	            case 2:
	            	selectShoppingCartMenuCase2(wareHouse, shoppingCart);
	                break;
	            case 3:
	            	selectShoppingCartMenuCase3(wareHouse, shoppingCart);
	                break;
	            case 4:
	            	selectShoppingCartMenuCase4(wallet, shoppingCart);
	                break;
	            case 5:
	            	selectShoppingCartMenuCase5(wareHouse, wallet, shoppingCart);
	                break;
	            case 6:
	            	selectShoppingCartMenuCase6();
                    break;
	            default:
	            	selectMainMenudefault();
	                break;
	            }   
	    }
	    while (choice != 6);
	    scanner.close();
	}
	
/********************Shopping Cart switch/case********************/

    public static void selectShoppingCartMenuCase1(ShoppingCart shoppingCart) {
    	System.out.println("View Items In Your Cart");
    	Displayer.displayShoppingCartTable(shoppingCart);
    }
    
    public static void selectShoppingCartMenuCase2(WareHouse wareHouse, ShoppingCart shoppingCart) {
    	System.out.println("Add Item/s To Your Cart");
        System.out.println("So far there are + " + shoppingCart.productsInCart + "items in your cart...\n");
        if(shoppingCart.performAdd(wareHouse)) {
            System.out.println("It worked");
        }
        else {
            System.out.println("Doesnt work");
        }
    }
    
    public static void selectShoppingCartMenuCase3(WareHouse wareHouse, ShoppingCart shoppingCart) {
    	System.out.println("Remove Item/s From Your Cart");
   	 	System.out.println("So far there are + " + shoppingCart.productsInCart + "items in your cart...\n");
        if(shoppingCart.performAdd(wareHouse)) {
               System.out.println("It worked");
        }
        else {
               System.out.println("Doesnt work");
        }
    }
    
    public static void selectShoppingCartMenuCase4(Wallet wallet, ShoppingCart shoppingCart) {
    	System.out.println("View Total Cost Of Your Cart");
    	System.out.println("the total for the cart is: " + shoppingCart.checkOut(wallet));
    }
    
    public static void selectShoppingCartMenuCase5(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingcart) {
    	System.out.println("Return To Main Menu");
    	SurvivalStore.selectMenuOp(wareHouse, wallet, shoppingcart);
    }
    
    public static void selectShoppingCartMenuCase6() {
    	System.out.println("Exiting Survival Store");
        System.out.println("Thank you for using our store app! Have a gread day :D");
        System.exit(0);
    }
    
    public static void selectMainMenudefault() {
    	System.out.println("The value you entered is not within the required range for this program (1..6), please re-enter\n");
    }

/********************shoppingcart message********************/
    public void displayShoppingCartWelcomeMessage() {
		 System.out.println("Welcome to the ShoppingCart, please enter a value between (1..6) \n\n");
	 }
    
	/**
	 * displays shopping cart menu options
	 */
	private void displaysShoppingCartMenuOptions() {
	        Displayer.printlnSleep(2500, "The menu is setup in the following way: \n\n");
	    	Displayer.printlnSleep(1500, "To view all Items in your cart currently enter 1\n");
	    	Displayer.printlnSleep(1500, "To add item/s to your cart enter 2\n");
	    	Displayer.printlnSleep(1500, "To remove item/s from your cart enter 3\n");
	    	Displayer.printlnSleep(1500, "To view total cost for your cart enter 4\n");
	    	Displayer.printlnSleep(1500, "To exit cart menu and return to main menu enter 5\n");
	    	Displayer.printlnSleep(1500, "To exit application enter: 6\n");
	}
	
/********************set & get shoppingcart********************/
	
	/**
	 * @return shoppingCartList, list of products the user has selected
	 */
	public List<Product> getCartList() {
		return shoppingCartList;
	}

/********************add & remove to/from shoppingcart*******************/
	
	/**
	 * adds product & increments number of products in users shopping cart
	 * @param product, instance of product to be added to shoppingCartList
	 */
	public void addToCart(Product product) {
		shoppingCartList.add(product);
	    productsInCart++;
	}
	
	/**
	 * removes product & decrements number of products in users shopping cart
	 * @param product, product to be removed from users shopping cart
	 */
	public void removeFromCart(Product product) {
		shoppingCartList.remove(product);
	    productsInCart--;
	}
	 
/********************add & remove from shoppingcart********************/
	
	/**
	 * Allows user to add product from to shopping cart
	 * @param warehouse, list of products in inventory
	 * @return successReturnValue, true if product added, false if not added
	 */
	private boolean performAdd(WareHouse wareHouse) {
	    boolean successReturnValue = false;
	    
	    /*
	     * prompts & receives input
	     */
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Please provide the name of the item you would like to add to the cart");
	    String userInput = scanner.nextLine();
	 
	    
	    Product product = new Product(); // empty product, default constructor

	    /*
	     * iterate through shopping cart list,
	     * if user input matches name of product, 
	     * get product from list of products/inventory,
	     * add product to shopping cart
	     * successfully returned
	     */
	    for (int i = 0; i < wareHouse.productList.size(); i++) {
	        if (i < wareHouse.productList.size()) {
	        	 if (userInput.equals(wareHouse.productList.get(i).getId())) {
	        		 product = wareHouse.productList.get(i);
	        		 wareHouse.productList.remove(i);
	        		 addToCart(product);
	        		 successReturnValue = true;
	        	 }
	        }  
	    }
	    scanner.close();
	    return successReturnValue;
	} // end of performAdd
	
	/**
	 * Allows user to remove product from shopping cart
	 * @param warehouse, list of products in inventory
	 * @return successReturnValue, true is product returned, false if not returned
	 */
	private boolean performSubtract(WareHouse warehouse) {
	    boolean successReturnValue = false;
	    
	    /*
	     * prompts & receives input
	     */
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Please provide the name of the item you would like to remove from the cart");
	    String userInput = scanner.nextLine();
	    
	    Product product = new Product(); // empty product, default constructor
    
	    /*
	     * iterate through shopping cart list,
	     * if user input matches name of product, 
	     * get product from shopping cart,
	     * add product back to warehouse
	     * remove product from cart
	     * successfully returned
	     */
	    for (int i = 0; i < shoppingCartList.size(); i++) { 
	        if (userInput.equals(shoppingCartList.get(i).getName())) {
	        	product = shoppingCartList.get(i);
	            removeFromCart(product);
	            warehouse.productList.add(product);
	            successReturnValue = true;
	        } 
	    }
	    scanner.close();
	    return successReturnValue;
	} // end of performSubtract
	
/********************purchase product(s)********************/
	
	/**
	 * iterates through products in shopping cart, 
	 * gets price of product as String, removes '$',
	 * converts String to double,
	 * @return totalPrice, collective price of products in shopping cart
	 * @throws NullPointerException
	 */
	private Double checkOut(Wallet wallet) {
	    Double totalPrice = 0.0;
	    String temp;
	    
	    for (int i = 0; i < shoppingCartList.size(); i++) {
	            temp = shoppingCartList.get(i).getPrice().replaceAll("$", "");
	            wallet.deductFromBalance(Double.parseDouble(temp));
	            totalPrice = Double.parseDouble(temp);  
	    }   
	    shoppingCartList.remove(shoppingCartList);
	    return totalPrice; 
	} 
}
