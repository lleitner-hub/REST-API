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
@RequestMapping("/invoice")
public class InvoiceController {
	@Resource
	public InvoiceService invoice;
	
	@RequestMapping("/createInvoice")
	public String createInvoice(@RequestParam(value="custId")long custId) {
		return invoice.createInvoice(custId);
	}
	
	@PutMapping("/addInvoiceItem")
	public Invoice addInvoiceItem(@RequestParam(value="invoId") long invoId,
								@RequestParam(value="prodId") long prodId,
								@RequestParam(value="quantity") long quantity){
		return invoice.addInvoiceItem(invoId, prodId, quantity);
	}
	@DeleteMapping("/removeItem")
	public String removeItem(@RequestParam(value="invoId") long invoId,
												@RequestParam(value="itemId") long itemId) {
		return invoice.removeItem(invoId, itemId);
	}
	
	@RequestMapping("/getInvoice")
	public Invoice getInvoice(@RequestParam(value="invoId") long invoId){
		return invoice.getInvoice(invoId);
	}
	
	@DeleteMapping("/deleteInvoice")
	public String deleteInvoice(@RequestParam(value="invoId") long invoId){
		return invoice.deleteInvoice(invoId);
	}
	
}
