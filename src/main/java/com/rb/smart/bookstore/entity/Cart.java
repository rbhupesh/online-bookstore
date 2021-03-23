package com.rb.smart.bookstore.entity;

import java.util.List;

public class Cart extends BaseEntity {
	
	List<Integer> books;

	public List<Integer> getBooks() {
		return books;
	}

	public void setBooks(List<Integer> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(" books:"+books.toString());

		return sb.toString() ;
	}	
}
