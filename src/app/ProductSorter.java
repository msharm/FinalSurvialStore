package app;


import java.util.Collections;
import java.util.Scanner;
import utilities.*;
import comparators.*;


/**
 * @author Reed
 */
public class ProductSorter {
	/**
	 * matches user input with sorter option(app functionality)
	 * @param productList, list of product inventory 
	 */
	 public static void selectSorterMenuOp(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) { 
		 displaySorterMenuOptions();
		 int useerInput;
	     Scanner scanner = new Scanner(System.in);
			do {
	            useerInput = scanner.nextInt();
	            
	            switch (useerInput) {
	                case 1:
	                	selectSorterMenuCase1(wareHouse);
	                	displaySortAgain(wareHouse, wallet, shoppingCart);
	                    break;
	                case 2:
	                	selectSorterMenuCase2(wareHouse);
	                	displaySortAgain(wareHouse, wallet, shoppingCart);
	                    break;
	                case 3:
	                	selectSorterMenuCase3(wareHouse);
	                	displaySortAgain(wareHouse, wallet, shoppingCart);
	                    break;
	                case 4:
	                	selectSorterMenuCase4(wareHouse, wallet, shoppingCart);
	                    break;
	                case 5:
	                	selectSorterMenuCase5();
	                    break;
	                default:
	                	selectSorterMenuDefault();
	                    break;
	            } 
	        }
	        while (useerInput != 5);
			scanner.close();
	 } // end of selectSorterMenuOp
	 
/********************Sorter Menu switch/case********************/

	    public static void selectSorterMenuCase1(WareHouse wareHouse) {
	    	System.out.println("***Sort By Name***");
        	Collections.sort(wareHouse.productList, new NameComparator());
        	Displayer.displayProductTable(wareHouse);
	    }
	    
	    public static void selectSorterMenuCase2(WareHouse wareHouse) {
	    	System.out.println("***Sort By Category***");
        	Collections.sort(wareHouse.productList, new CategoryComparator());
        	Displayer.displayProductTable(wareHouse);
	    }
	    
	    public static void selectSorterMenuCase3(WareHouse wareHouse) {
	    	System.out.println("***Sort By Price***");
        	Collections.sort(wareHouse.productList, new PriceComparator());
        	Displayer.displayProductTable(wareHouse);
	    }
	    
	    public static void selectSorterMenuCase4(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
	    	System.out.println("***Main Menu***");
        	SurvivalStore.displayMainMenuWelcomeMessage();
        	SurvivalStore.selectMenuOp(wareHouse, wallet, shoppingCart);
	    }
	    
	    public static void selectSorterMenuCase5() {
	    	System.out.println("***Exiting Survival Store***");
	        System.out.println("Thank you for using our store app! Have a gread day :D");
	        System.exit(0);
	    }
	    
	    public static void selectSorterMenuDefault() {
	    	System.out.println("The value you entered is not within the required range for this program (1..5), please re-enter\n");
	    }

	 
/********************sorter message********************/
	 
	 /**
	 * displays sorter welcome message
	 */
	 public static void displaySorterWelcomeMessage() {
		 System.out.println("Welcome to the Product Sorter, please enter a value between (1..5) \n\n");
	 }
	    
	  /**
	  * displays sorter menu options
	  */
	 public static void displaySorterMenuOptions() {
		 	Displayer.printlnSleep(2500, "The menu is setup in the following way: \n\n");
	    	Displayer.printlnSleep(1500, "-To sort products by name, enter: 1\n");
	    	Displayer.printlnSleep(1500, "-To sort products by category, enter: 2\n");
	    	Displayer.printlnSleep(1500, "-To sort products by price, enter: 3\n");
	    	Displayer.printlnSleep(1500, "-To return to the Main Menu, enter: 4\n");
	    	Displayer.printlnSleep(1500, "-To exit Survival Store, enter: 5\n");
	 }
	 
	 public static void displaySortAgainWelcomeMessage() {
		 System.out.println("Would you like to Sort Again? Please enter a value between (1..3) \n\n");
	 }
	 
	 public static void displaySortAgainMenuOptions() {
		 	Displayer.printlnSleep(2500, "The menu is setup in the following way: \n\n");
	    	Displayer.printlnSleep(1500, "-To sort products again, enter: 1\n");
	    	Displayer.printlnSleep(1500, "-To return to the Main Menu, enter: 2\n");
	    	Displayer.printlnSleep(1500, "-To exit Survival Store, enter: 3\n");
	 }
	 
	 public static void displaySortAgain(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
		displaySortAgainWelcomeMessage();
		displaySortAgainMenuOptions();
		int useerInput;
	     Scanner scanner = new Scanner(System.in);
			do {
	            useerInput = scanner.nextInt();
	            
	            switch (useerInput) {
	                case 1:
	                	System.out.println("***Sort Again***");
	                	selectSorterMenuOp(wareHouse, wallet, shoppingCart);
	                    break;
	                case 2:
	                	selectSorterMenuCase4(wareHouse, wallet, shoppingCart);
	                    break;
	                case 3:
	                	selectSorterMenuCase5();
	                    break;
	                default:
	                	selectSorterMenuDefault();
	                    break;
	            } 
	        }
	        while (useerInput != 3);
			scanner.close();
	 	}
}


