package comparators;

import java.util.Comparator;

import app.*;

public class CategoryComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getCategory().compareToIgnoreCase(o2.getCategory());
	}
}
