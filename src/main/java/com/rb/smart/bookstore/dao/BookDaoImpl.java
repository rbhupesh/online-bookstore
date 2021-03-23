package com.rb.smart.bookstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rb.smart.bookstore.dao.repo.BookRepository;
import com.rb.smart.bookstore.entity.Book;

public class BookDaoImpl implements BookDao {

	@Autowired
	private BookRepository bookingRepository;


	@Override
	public Book getBookByISBN(String isbn) {

		Book book = bookingRepository.findByISBN(isbn);

		System.out.println("BookDaoImpl.getBookById ENDS");
		return book;
	}


	@Override
	public Book addBook(Book book) {
		
		Book book1 = bookingRepository.saveAndFlush(book);

		System.out.println("BookDaoImpl.addBook ENDS");
		return book1;
	}


	@Override
	public List<Book> findAllBooksByIDs(List<Integer> list) {
		
		List<Book> books = bookingRepository.findAllById(list);
		
		System.out.println("BookDaoImpl.findAllBooksByIDs ENDS");
		return books;
	}
}
