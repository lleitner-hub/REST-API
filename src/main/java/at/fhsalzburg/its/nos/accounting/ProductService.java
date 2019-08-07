package at.fhsalzburg.its.nos.accounting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductService {

	private static Map<Long, Product>products= new HashMap<Long, Product>();
	
	public synchronized String generateProduct(Product prod) {
		products.put(prod.getProdId(), prod);
		return "Product: "+prod.getProdName()+" succesfully generated";
	}

	public synchronized static Product getProduct(long prodId) {
		return products.get(prodId);
	}

	public synchronized Collection<Product> getAllProducts() {
		return products.values();
	}

	public synchronized String deleteProduct(long prodId) {
		Product tempProduct = products.get(prodId);
		products.remove(prodId);
		return "Product: "+tempProduct.getProdName()+ " deleted";
	}

	public synchronized String deleteAllProducts() {
		products.clear();
		return "Every product deleted";
	}

	public synchronized Product updateProduct(long prodId, Product prod) {
		prod.setProdId(prodId);
		products.put(prodId, prod);
		return products.get(prodId);
	}

}
