package at.fhsalzburg.its.nos.accounting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class InvoiceService {
private Map<Long, Invoice>invoices= new HashMap<Long, Invoice>();
	
	public synchronized String createInvoice(long custId) {
		if(CustomerService.getCustomer(custId) != null) {
			Invoice tempInvoice = new Invoice(custId);
			invoices.put(tempInvoice.getInvoId(), tempInvoice);
			return "Invoice (Id:"+tempInvoice.getInvoId() +") for: "+tempInvoice.getCust().getCustName()+" succesfully generated";
		}
		return "Invoice could not generated. Customer does not exist!";
	}
	
	public synchronized Invoice addInvoiceItem(long invoId, long productId, long quantity) {
		//does product exist?
		if(ProductService.getProduct(productId) != null) {
			//get all products what currently in this invoice are
			Map<Long, Item> items = invoices.get(invoId).getItems();
			//is there already the same item?
			for (Map.Entry<Long, Item> item : items.entrySet()) {
				if(item.getValue().getProduct().getProdId() == productId) {
					//set quantity and totalprice new
					invoices.get(invoId).getItems().get(item.getKey()).setQuantity(quantity);
					invoices.get(invoId).getItems().get(item.getKey()).setTotalItemPrice(quantity*item.getValue().getProduct().getProdPrice());
					//calculate the invoice price again
					invoices.get(invoId).setInvoPrice(invoices.get(invoId).calcInvoicePrice());
					return invoices.get(invoId);
				}
			}
			//generate a new Item an add it to the itemlist
			Item newItem = new Item(ProductService.getProduct(productId), quantity);
			invoices.get(invoId).getItems().put(newItem.getItemId(), newItem);
			//calculate the invoice price again
			invoices.get(invoId).setInvoPrice(invoices.get(invoId).calcInvoicePrice());
		}
		return invoices.get(invoId);
	}
	
	public synchronized String removeItem(long invoId, long itemId) {
		if(invoices.get(invoId).getItems().remove(itemId) != null) {
			return "Item successfully from current Itemlist deleted";
		}
		return "Item was not found in current Itemlist.";
	}
	

	public synchronized Invoice getInvoice(long invoId) {
		return invoices.get(invoId);
	}
	
	public synchronized Collection<Invoice> getAllInvoices() {
		return invoices.values();
	}

	public synchronized String deleteInvoice(long invoId) {
		Invoice tempInvoice = invoices.get(invoId);
		invoices.remove(invoId);
		return "Invoice (Id): "+tempInvoice.getInvoId()+ " deleted";
	}

	public synchronized String deleteAllInvoices() {
		invoices.clear();
		return "Every product deleted";
	}

}
