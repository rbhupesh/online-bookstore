package com.rb.smart.bookstore.entity;

public class Amount {
	
	float total;

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(" total :"+total);

		return sb.toString() ;
	}	
}
