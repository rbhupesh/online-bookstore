package com.rb.smart.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Book extends BaseEntity {
	
	@Id
	@SequenceGenerator(name = "BOOK_ID_SEQ", sequenceName = "BOOK_ID_SEQ",initialValue=10, allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_ID_SEQ")
	@Column(name = "id")
	private int id;
	
	String Name;
	String Description;
	String Author;
	String Classification;
	float Price;
	String ISBN;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getClassification() {
		return Classification;
	}

	public void setClassification(String classification) {
		Classification = classification;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(" id:"+id);
		sb.append(", Name:"+Name);
		sb.append(", Description: "+Description);
		sb.append(", Author: "+Author);
		sb.append(", Classification: "+ Classification);
		sb.append(", Price: "+ Price);
		sb.append(", ISBN: "+ ISBN);
		
		return sb.toString() ;
	}	
}
