package at.fhsalzburg.its.nos.accounting;

import java.util.concurrent.atomic.AtomicLong;

public class Product {
	private static final AtomicLong counter = new AtomicLong();;
	private long prodId;
	private float prodPrice;
	private String prodName;
	
	public Product(String name, float price) {
		this.prodId = counter.getAndIncrement();
		this.prodPrice = price;
		this.prodName = name;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public float getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
}
