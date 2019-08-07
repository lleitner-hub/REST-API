package at.fhsalzburg.its.nos.accounting;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Invoice {
	private static final AtomicLong counter = new AtomicLong();;
	private long invoId, invoPrice;
	private Map<Long, Item> items = new HashMap<Long, Item>();
	private Customer cust;
	public Invoice(long custId) {
		this.invoId = counter.getAndIncrement();
		this.setCust(CustomerService.getCustomer(custId));
	}

	public long getInvoId() {
		return invoId;
	}

	public void setInvoId(long invoId) {
		this.invoId = invoId;
	}

	public Map<Long, Item> getItems() {
		return items;
	}

	public void setItems(Map<Long, Item> items) {
		this.items = items;
	}
	
	public long calcInvoicePrice() {
		long sum =0 ;
		for (Map.Entry<Long, Item> item : items.entrySet()) {
			sum+=item.getValue().getTotalItemPrice();
		}
		return sum;
	}

	public long getInvoPrice() {
		return invoPrice;
	}

	public void setInvoPrice(long invoPrice) {
		this.invoPrice = invoPrice;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
}
