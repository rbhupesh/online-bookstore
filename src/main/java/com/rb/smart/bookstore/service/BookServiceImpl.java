package com.rb.smart.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rb.smart.bookstore.dao.BookDao;
import com.rb.smart.bookstore.entity.Book;

public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public Book getBookByISBN(String isbn) {
		
		Book book  = bookDao.getBookByISBN(isbn);
		System.out.println("BookServiceImpl.getBookByISBN() ENDS");
		return book;
	}

	@Override
	public Book addBook(Book book) {
		
		Book book1  = bookDao.addBook(book);
		
		System.out.println("BookServiceImpl.addBook() ENDS");
		return book1;
	}
}
