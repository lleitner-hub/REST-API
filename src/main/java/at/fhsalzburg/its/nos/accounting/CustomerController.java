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
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	public CustomerService customer;
	
	@RequestMapping("/createCustomer")
	public String generateCustomer(@RequestBody Customer cust) {
		return customer.generateCustomer(cust);
	}
	
	@RequestMapping("/getCustomer")
	public Customer getCustomer(@RequestParam(value="custId") long custId) {
		return customer.getCustomer(custId);
	}
	@RequestMapping("/getAllCustomers")
	public Collection<Customer>getAllCustomers() {
		return customer.getAllCustomers();
	}
	
	@DeleteMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam(value="custId") long custId){
		return customer.deleteCustomer(custId);
	}
	
	@DeleteMapping("/deleteAllCustomers")
	public String deleteAllCustomer(){
		return customer.deleteAllCustomer();
	}
	
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestParam(value="custId") long custId,
									@RequestBody Customer cust) {
		return customer.updateCustomer(custId, cust);
	}
	 
}
