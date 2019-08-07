package at.fhsalzburg.its.nos.accounting;

import java.util.concurrent.atomic.AtomicLong;

public class Item {
	private long itemId;
	private Product product;
	private long quantity;
	private float totalItemPrice;
	private static final AtomicLong counter = new AtomicLong();
	
	public Item(Product prod, long quantitiy) {
		this.itemId = counter.getAndIncrement();
		this.product = prod;
		this.quantity = quantitiy;
		this.totalItemPrice = quantitiy*prod.getProdPrice();
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public float getTotalItemPrice() {
		return totalItemPrice;
	}

	public void setTotalItemPrice(float totalPrice) {
		this.totalItemPrice = totalPrice;
	}
	
}
