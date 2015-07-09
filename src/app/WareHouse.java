package app;

import java.io.*;
import java.util.*;

/**
 * @author Reed
 */
public class WareHouse {
	public List<Product> productList = new ArrayList<>();
	
	/*initialize with empty Strings*/
	private String fileName = "";
  	private String line = "";
  
  /**
   * creates warehouse
   * default constructor 
   */
  public WareHouse() {
	  
  }
  
  /**
   * creates warehouse
   * initializes wareHouse.fileName with file(.CSV)
   * @param file(String value) a .CSV holding productList/inventory
   */
  public WareHouse(String file){
      this.fileName = file;
  }
  
  /**
   * declare-initialize firstLine(boolean), bufferedReader(BufferedReader)
   * 
   * try: instantiate-initialize bufferedReader with fileName(String), a .CSV holding productList/inventory
   * 
   * while ((set line(String) EQUAL to return of bufferedReader.readLine()) is NOT EQUAL to null)
   * readLine() reads a line of text, lines are terminated by '\n'
   * 
   * if (firstLine evaluates true), set firstLine EQUAL to false
   * else, declare-instantiate-initialize: product(Product) with line
   * append product(specified element) to the end of productList 
   * 
   * catch e(IOException): if failed or interrupted I/O operation, prints e and its backtrace to the standard error stream
   * 
   * finally: if bufferedReader is NOT EQUAL to null, close bufferedReader's stream &  associated resources
   * 
   * @throws IOException
   * @BufferedReader(bufferedReader) reads text from a character-input stream
   * @FileReader(fileReader) reads character files(fileName)
   */
  public void loadData() throws IOException {
	  	boolean firstLine = true;
        BufferedReader bufferedReader = null;
        
        try{
            bufferedReader = (new BufferedReader(new FileReader(fileName)));
            
            while ((line = bufferedReader.readLine()) != null) {
            	if(firstLine) {
            		firstLine = false;
            	}
            	else {
            		Product product = new Product(line);
            		productList.add(product);
            	}
            }
        }
        catch (IOException e) { 
        	e.printStackTrace();
        }
        finally {
            if (bufferedReader  != null) {
                try {
                    bufferedReader.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
           }
        }
  } //end of loadData
}

