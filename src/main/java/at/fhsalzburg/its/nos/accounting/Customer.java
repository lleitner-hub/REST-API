package at.fhsalzburg.its.nos.accounting;


import java.util.concurrent.atomic.AtomicLong;



public class Customer {
		private static final AtomicLong counter = new AtomicLong();
		private long custId;
		private String custName, custStreet, custZip, custBrithday, custCity;
		
		public Customer(String name, String street, String zip, String city, String birthday) {
			this.custId = counter.getAndIncrement();
			this.custName = name;
			this.custStreet = street;
			this.custZip = zip;
			this.custCity = city;
			this.custBrithday = birthday;
		}

		public String getCustCity() {
			return custCity;
		}

		public void setCustCity(String custCity) {
			this.custCity = custCity;
		}
		
		public long getCustId() {
			return custId;
		}

		public void setCustId(long custId) {
			this.custId = custId;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getCustStreet() {
			return custStreet;
		}

		public void setCustStreet(String custStreet) {
			this.custStreet = custStreet;
		}

		public String getCustZip() {
			return custZip;
		}

		public void setCustZip(String custZip) {
			this.custZip = custZip;
		}

		public String getCustBrithday() {
			return custBrithday;
		}

		public void setCustBrithday(String custBrithday) {
			this.custBrithday = custBrithday;
		}
		
		
}
