package comparators;

import java.util.Comparator;

import app.Product;

/**
 * 
 * @author Reed
 *
 */
public class PriceComparator implements Comparator<Product> {
	@Override
	public int compare(Product o1, Product o2) {
		if(o1.getPriceNum() == o2.getPriceNum()) {
			return 0;
		}
		else if(o1.getPriceNum() > o2.getPriceNum()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}