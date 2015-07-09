
package app;

import java.util.UUID;

/**
 *
 * @author Reed
 */
public class Product {
    /**********name & category**********/
	private String name = "";
    private String category = "";
    
    /**********line: all the comma separated values associated with one product**********/
    private String line = ";-)";
    private final String CSV_SPLIT_VALUE = ",";
    private String uniqueID = "";
    
    /**********priceString**********/
    private String priceString = "";
    private Double priceNum = 0.0;
    
    /**********inventory**********/
    private String inventory = "";
    private int inventoryNum = 0;
    
    /**
     * default constructor 
     */
    public Product(){
      
    }
    
    /**
     * 
     * @param line
     */
    public Product(String line) {
    	this.line = line;
    	splitLine(line);
    }
    
    @Override
    public String toString() {
    	return line;
    }
    
    /**
     * 
     * @param line
     */
    private void splitLine(String line) {
		String[] productInfo = line.split(CSV_SPLIT_VALUE);
		
		this.category = productInfo[0];
		this.name = productInfo[1];
		this.priceString = productInfo[2];
		this.inventory = productInfo[3];
		uniqueID = UUID.randomUUID().toString();
	}
    
/********************get & set product********************/
    
/**********ID**********/
    
    public String getId() {
		return uniqueID;
	}

	public void setId(String uniqueID) {
		this.uniqueID = uniqueID;
	}
    
/**********name***********/
    
	/**
     * 
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
/**********category**********/
    
    /**
     * 
     * @return
     */
    public String getCategory(){
        return category;
    }
    
    /**
     * 
     * @param category
     */
    public void setCategory(String category){
        this.category = category;
    }
    
/**********priceString**********/
    
    /**
     * 
     * @return
     */
    public String getPrice(){
        return priceString;
    }
    
    /**
     * 
     * @param priceString
     */
    public void setPrice(String priceString){
        this.priceString = priceString;
    }
    
    /**
     * 
     * @return
     */
    public double getPriceNum() {
    	String priceTemp = priceString.replaceAll("$", "");
        priceNum = Double.parseDouble(priceTemp); 
    	return priceNum;
    }
        
/**********inventory**********/
    
    /**
     * 
     * @return
     */
    public String getInventory(){
        return inventory;
    }
    
    /**
     * 
     * @param inventory
     */
    public void setInventory(String inventory){
        this.inventory = inventory;
    }
    
    /**
     * 
     * @param inventory
     */
    private void setInventoryNum(String inventory) {
    	inventoryNum = Integer.parseInt(inventory);
    }
    
    /**
     * 
     * @return
     */
    public boolean isInventoryInStock() {
    	return (inventoryNum > 0 ? true : false);
    }
    
    /**
     * 
     * @param inventory
     * @return
     */
    public boolean subtractInventoryValue(int inventory) {
    	if(isInventoryInStock()) {
    		inventoryNum = inventoryNum - inventory;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
