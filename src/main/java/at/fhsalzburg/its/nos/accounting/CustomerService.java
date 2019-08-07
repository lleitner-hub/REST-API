package at.fhsalzburg.its.nos.accounting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerService {
	

	private static Map<Long, Customer>customers= new HashMap<Long, Customer>();
	
	public synchronized String generateCustomer(Customer cust) {
		customers.put(cust.getCustId(), cust);
		return "Customer: "+cust.getCustName()+" succesfully generated";
	}
	
	public synchronized static Customer getCustomer(long id) {
		return customers.get(id);
	}

	public synchronized Collection<Customer> getAllCustomers() {
		return customers.values();
	}
	
	public synchronized String deleteCustomer(long id) {
		Customer tempCust = customers.get(id);
		customers.remove(id);
		return "Customer: "+tempCust.getCustName()+ " deleted";
	}

	public synchronized String deleteAllCustomer() {
		customers.clear();
		return "Every customer deleted";
	}

	public synchronized String updateCustomer(long custId, Customer cust) {
		cust.setCustId(custId);
		if(customers.replace(custId, cust) != null){
			customers.get(custId);
			return "Customer succesfully updated";
		}
		return "Customer update error: Could not find customer";
	}
	
	
	
}
