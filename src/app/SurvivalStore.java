package app;


import java.io.IOException; // io
import java.util.Scanner; // util

import utilities.Displayer; // utilities

/**
 * @author Reed
 */
public class SurvivalStore {

    /**
     * entry point of application
     * create a wallet, set a random starting value
     * create a shopping cart
     * generate & display Survival Store Logo & image/GUI
     * display Survival Store & Main Menu Welcome
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        WareHouse wareHouse = new WareHouse("resources/survival_store_inventory.csv");
        wareHouse.loadData();
        
        Wallet wallet = new Wallet();
        wallet.setRandomStartingBalance(20.0, 500.0);
        
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Displayer.generateDisplaySurvivalStoreLogo();
        javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() { Displayer.generateDisplayGUI("resources/SurvivalStore.png"); } });
        
        displaySurvivalStoreWelcomeMessage();
        displayMainMenuWelcomeMessage();
        selectMenuOp(wareHouse, wallet, shoppingCart);
    }
    
    /**
     * matches user input with Main Menu option(app functionality)
     */
    public static void selectMenuOp(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) { 
    	displayMainMenuOptions();
        int choice;
        
        Scanner scanner = new Scanner(System.in);
		do {
            choice = scanner.nextInt();
            
            switch (choice){
                
                case 1:
                	selectMainMenuCase1(wareHouse, wallet, shoppingCart);
                    break;
                case 2:
                	selectMainMenuCase2(wareHouse, wallet, shoppingCart);
                    break;
                case 3:
                	selectMainMenuCase3(wareHouse, wallet, shoppingCart);
                	break;
                case 4:
                	selectMainMenuCase4(wareHouse, wallet, shoppingCart);
                    break;
                case 5:
                	selectMainMenuCase5();
                    break;
                default:
                	selectMainMenudefault();
                    break;
            } 
        }
        while (choice != 5);
		scanner.close();
    } //end of selectMenuOp
    
/********************Main Menu switch/case
 * @param wallet 
 * @param shoppingCart ********************/

    public static void selectMainMenuCase1(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
    	System.out.println("***All Products***\n");
    	Displayer.displayProductTable(wareHouse);
    	displayMainAgain(wareHouse, wallet, shoppingCart);
    }
    
    public static void selectMainMenuCase2(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
    	System.out.println("***Sort Products***\n");
    	ProductSorter.displaySorterWelcomeMessage();
    	ProductSorter.selectSorterMenuOp(wareHouse, wallet, shoppingCart);
    }
    
    public static void selectMainMenuCase3(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
    	System.out.println("***Your Shopping Cart***\n");
    	shoppingCart.displayShoppingCartWelcomeMessage();
    	shoppingCart.selectShoppingCartMenuOp(wareHouse, wallet, shoppingCart);
    }
    
    public static void selectMainMenuCase4(WareHouse warehouse, Wallet wallet, ShoppingCart shoppingCart) {
    	System.out.println("***Your Wallet***\n");
    	wallet.displayWalletWelcomeMessage();
    	wallet.selectWalletMenuOp(warehouse, wallet, shoppingCart);
//    	wallet.getBalance();
    }
    
    public static void selectMainMenuCase5() {
    	System.out.println("***Exiting Survival Store***\n");
        System.out.println("Thank you for using our store app! Have a gread day :D");
        System.exit(0);
    }
    
    public static void selectMainMenudefault() {
    	System.out.println("The value you entered is not within the required range for this program (1..5), please re-enter\n");
    }

/********************Survival Store & Main Menu Message********************/
    
    /**
     * displays Survival Store welcome message
     */
    public static void displaySurvivalStoreWelcomeMessage(){
        System.out.println("\n\nHello! This is our text based store application.\n\n");
    }
    
    /**
     * displays Main Menu welcome message
     */
    public static void displayMainMenuWelcomeMessage(){
        System.out.println("Welcome to the Main Menu, please enter a value between (1..5) \n\n");
    }
    
    /**
     * displays Main Menu options
     */
    public static void displayMainMenuOptions() {
    	Displayer.printlnSleep(2500, "The menu is setup in the following way: \n\n");
    	Displayer.printlnSleep(1500, "-To see all products enter: 1\n");
    	Displayer.printlnSleep(1500, "-To go into the sort menu enter: 2\n");
    	Displayer.printlnSleep(1500, "-To view cart enter: 3\n");
    	Displayer.printlnSleep(1500, "-To check wallet enter: 4\n");
    	Displayer.printlnSleep(1500, "-To exit application enter: 5\n" );
    }
  
/********************Main Menu Again Message & Display********************/
    
    public static void displayMainAgainWelcomeMessage() {
		 System.out.println("Would you like to Return to the Main Menu? Please enter a value between (1..2) \n\n");
	 }
	 
	 public static void displayMainAgainMenuOptions() {
		 	Displayer.printlnSleep(2500, "The menu is setup in the following way: \n\n");
	    	Displayer.printlnSleep(1500, "-To return to the Main Menu, enter: 1\n");
	    	Displayer.printlnSleep(1500, "-To exit Survival Store, enter: 2\n");
	 }
    
    public static void displayMainAgain(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
		displayMainAgainWelcomeMessage();
		displayMainAgainMenuOptions();
		int useerInput;
	     Scanner scanner = new Scanner(System.in);
			do {
	            useerInput = scanner.nextInt();
	            
	            switch (useerInput) {
	                case 1:
	                	System.out.println("***Main Again\n***");
	                	selectMenuOp(wareHouse, wallet, shoppingCart);
	                    break;
	                case 2:
	                	selectMainMenuCase5();
	                    break;
	                default:
	                	selectMainMenudefault();
	                    break;
	            } 
	        }
	        while (useerInput != 3);
			scanner.close();
	 	}
}
