package utilities;


import java.awt.Font; // awt
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File; // io
import java.io.IOException;
import java.util.Arrays; // util
import java.util.List;

import javax.imageio.ImageIO; // imageio
import javax.swing.ImageIcon; // swing
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.Product; // app
import app.ShoppingCart;
import app.WareHouse;

import com.bethecoder.ascii_table.ASCIITable; // ascii_table
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;


public class Displayer {
    
    /** 
     * @param productList(List<Product>) a list of products/inventory
     */
    public static void displayProductTable(List<Product> productList) {
    }

/*******************Logo & Image, Generation & Display***************/
   
    
    /**

     * displays Survival Store 'logo'
     * 
     * declare-instantiate-initialize, bufferedImage, pass in: 
     * width(int) - width of the created image
     * height(int) - height of the created image
     * imageType(int) - type of the created image
     * TYPE_INT_RGB(int), image with 8-bit RGB color components packed into integer pixels
     * 
     * declare-instantiate, graphics(Graphics), to encapsulate state information returned from createGraphics
     * needed for the basic rendering operations
     * 
     * createGraphics, creates a Graphics2D, which can be used to draw into this BufferedImage
     * 
     * set graphics context's font to the specified font:
     * instantiate-initialize, Font, creates a new Font from the specified: 
     * name - Dialog, a family name for a logical font
     * style - PLAIN, a constant for the Font(renders text in a visible way) The style argument is an integer bitmask 
     * point size - the point size of the Font
     * 
     * declare-initialize, graphics2D, cast graphics to Graphics2D
     * set the value of a single preference for the rendering algorithms:
     * hintKey - the key(KEY_TEXT_ANTIALIASING) of the hint to be set
     * hintValue - the value(VALUE_TEXT_ANTIALIAS_ON) indicating preferences for the specified hint category
     * drawString renders the text of the specified String(SurvivalStore), 
     * using the current text attribute state in the Graphics2D context:
     * str - the string to be rendered
     * x - the x coordinate of the location where the String should be rendered
     * y - the y coordinate of the location where the String should be rendered
     * 
     * try, write an image using an arbitrary ImageWriter(bufferedImage) 
     * that supports the given format(png) to a File(text.png)
     * 
     * catch e(IOException), if failed or interrupted I/O operation, 
     * prints e and its backtrace to the standard error stream
     * 
     * loop while (y(int) EQUALS 0 is LESS THAN 32) increment y by 1 each iteration,
     * every iteration, declare-instantiate-initialize, StringBuilder
     * 
     * loop while (x(int) EQUALS 0 is LESS THAN 144) increment x by 1 each iteration,
     * check if bufferedImage's integer pixel in the default RGB color model and default sRGB colorspace,
     * are EQUIVALENT to -16777216, if ture, append space, if false, append "#", if bufferedImage integer pixel 
     * in the default RGB color model and default sRGB colorspace, are EQUIVALENT to -1, & "*" if not EQUIVALENT to -1
     * 
     * if (stringBuilder is empty) continue
     * 
     * print " " or "#" or "*"
     * 
     * @BufferedImage describes an Image with an accessible buffer of image data
     * 
     * @Graphics abstract base class for all graphics contexts that allow an application to
     * draw onto components that are realized on various devices, as well as onto off-screen images
     * 
     * @Graphics2D extends the Graphics class to provide more sophisticated control over geometry, 
     * coordinate transformations, color management, and text layout
     * 
     * @ImageIO class containing static convenience methods for locating 
     * ImageReaders and ImageWriters, and performing simple encoding and decoding
     * 
     * @StringBuilder A mutable sequence of characters
     * 
     */
    public static void generateDisplaySurvivalStoreLogo() {
    	BufferedImage bufferedImage = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
    	
		Graphics graphics = bufferedImage.createGraphics();
		graphics.setFont(new Font("Dialog", Font.PLAIN, 24));
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics2d.drawString("Survival Store", 6, 24);
		
		try {
			ImageIO.write(bufferedImage, "png", new File("resources/SurvivalStore.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		for (int y = 0; y < 32; y++) {
		    StringBuilder stringBuilder = new StringBuilder();
		    
		    for (int x = 0; x < 144; x++) {
		        stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ? " " : bufferedImage.getRGB(x, y) == -1 ? "#" : "*");
		    }
		    
		    if (stringBuilder.toString().trim().isEmpty()) {
		    	continue;
		    }
		    
		    System.out.println(stringBuilder);
		}
    } //end of displaySurvivalStore
    
    public static void generateDisplayGUI(String filePath) {
        //Create and set up the window.
        JFrame frame = new JFrame("***Survival Store***");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
        	BufferedImage bufferedImage = ImageIO.read(new File(filePath));
        	//Add the ubiquitous "Hello World" label.
        	JLabel label = new JLabel(new ImageIcon(bufferedImage));
        	frame.getContentPane().add(label);
        }
        catch (IOException e) {
    		e.printStackTrace();
    	}

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
/********************Thread Sleeps********************/
  
    /**
     * 
     * @param sleepNumber
     * @param outPut
     */
    public static void printlnSleep(int sleepNumber, String outPut) {
 	   try {
 		   Thread.sleep(sleepNumber);
 	   } 
 	   catch (InterruptedException e) {
 		   e.printStackTrace();
 	   }
 	   System.out.println(outPut);
    }
    /**
     * 
     * @param sleepNumber
     * @param outPut
     */
    public static void printSleep(int sleepNumber, String outPut) {
 	   try {
 		   Thread.sleep(sleepNumber);
 	   } 
 	   catch (InterruptedException e) {
 		   e.printStackTrace();
 	   }
 	   System.out.print(outPut);
    }
    
/********************Display List************************/

    public static void displayProductTable(WareHouse wareHouse) {          
 	   IASCIITableAware asciiTableAware = new CollectionASCIITableAware<Product>(wareHouse.productList, 
 	   Arrays.asList("id", "name", "category", "price"), Arrays.asList("id", "Name", "Category", "Price"));
 	   ASCIITable.getInstance().printTable(asciiTableAware);
    }
    
    public static void displayShoppingCartTable(ShoppingCart shoppingCart) {          
  	   IASCIITableAware asciiTableAware = new CollectionASCIITableAware<Product>(shoppingCart.shoppingCartList, 
  	   Arrays.asList("id", "name", "category", "price"), Arrays.asList("id", "Name", "Category", "Price"));
  	   ASCIITable.getInstance().printTable(asciiTableAware);
    }
}
