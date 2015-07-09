package app;

import java.util.Random;
import java.util.Scanner;

import utilities.Displayer;

public class Wallet {
	private double balance;

	/**
	 * default Wallet constructor
	 */
	public Wallet() {
		
	}
	
	/**
	 * matches user input with Wallet option(app functionality)
	 * @param shoppingCart 
	 * @param productList, list of product inventory 
	 */
	 public void selectWalletMenuOp(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) { 
		 displayWalletMenuOptions();
		 int useerInput;
	     Scanner scanner = new Scanner(System.in);
			do {
	            useerInput = scanner.nextInt();
	            
	            switch (useerInput) {
	                case 1:
	                	selectWalletMenuCase1(wallet);
	                    break;
	                case 2:
	                	selectWalletMenuCase2(wareHouse, wallet, shoppingCart);
	                    break;
	                case 3:
	                	selectWalletMenuCase3();
	                    break;
	                default:
	                	selectSorterMenuDefault();
	                    break;
	            } 
	        }
	        while (useerInput != 3);
			scanner.close();
	 } // end of selectSorterMenuOp
	 
/********************Wallet Menu switch/case********************/

	    public static void selectWalletMenuCase1(Wallet wallet) {
	    	System.out.println("Current Balance Of Wallet");
        	wallet.getBalance();
	    }
	    
	    public static void selectWalletMenuCase2(WareHouse wareHouse, Wallet wallet, ShoppingCart shoppingCart) {
	    	System.out.println("Main Menu");
        	SurvivalStore.displayMainMenuWelcomeMessage();
        	SurvivalStore.selectMenuOp(wareHouse, wallet, shoppingCart);
	    }
	    
	    public static void selectWalletMenuCase3() {
	    	System.out.println("Exiting Survival Store");
        	System.out.println("Thank you for using our store app! Have a gread day :D");
            System.exit(0);
	    }
	    
	    public static void selectSorterMenuDefault() {
	    	System.out.println("The value you entered is not within the required range for this program (1..3), please re-enter\n");
	    }

/********************wallet message********************/
	 
	 /**
	 * displays wallet welcome message
	 */
	 public void displayWalletWelcomeMessage() {
		 System.out.println("Welcome to your Wallet, please enter a value between (1..3) \n\n");
	 }
	    
	  /**
	  * displays wallet menu options
	  */
	 public void displayWalletMenuOptions() {
		 	Displayer.printlnSleep(2500, "The menu is setup in the following way: \n\n");
	    	Displayer.printlnSleep(1500, "To get Wallets current balance, enter: 1\n");
	    	Displayer.printlnSleep(1500, "To return to the Main Menu, enter: 2\n");
	    	Displayer.printlnSleep(1500, "To exit Survival Store, enter: 3\n");
	 }

/***************balance********************/
	 
	/**
	* @return balance(double value) of wallet
	*/
	 public double getBalance() {
		 return balance;
	 }

	/**
	 * @param price(double value) of a product
	 */
	public void deductFromBalance(double price) {
		//TO-DO: if balance is greater than price, deduct price from balance
		this.balance = balance - price;
	}

	/**
	 * Sets random starting balance of wallet
	 * @param minimum(double value) balance wallet can hold
	 * @param maximum(double value) balance wallet can hold
	 */
	public void setRandomStartingBalance(double minimum, double maximum) {
		Random random = new Random();
		double randomStartingBalance = minimum + (maximum - minimum) * random.nextDouble();
		balance = randomStartingBalance;
	}
}
