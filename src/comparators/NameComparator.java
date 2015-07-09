package comparators;

import java.util.Comparator;

import app.Product;

/**
 * 
 * @author Reed
 *
 */
public class NameComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
}

