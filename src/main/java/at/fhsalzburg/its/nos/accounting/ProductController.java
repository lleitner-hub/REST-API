package at.fhsalzburg.its.nos.accounting;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Resource
	public ProductService product;
	
	@RequestMapping("/createProduct")
	public String generateProduct(@RequestBody Product prod) {
		return product.generateProduct(prod);
	}
	
	@RequestMapping("/getProduct")
	public Product getProduct(@RequestParam(value="prodId") long prodId) {
		return product.getProduct(prodId);
	}
	@RequestMapping("/getAllProducts")
	public Collection<Product> getAllProducts() {
		return product.getAllProducts();
	}
	
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestParam(value="prodId") long prodId){
		return product.deleteProduct(prodId);
	}
	
	@DeleteMapping("/deleteAllProducts")
	public String deleteAllProducts(){
		return product.deleteAllProducts();
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestParam(value="prodId") long prodId,
									@RequestBody Product prod) {
		return product.updateProduct(prodId, prod);
	}
}
