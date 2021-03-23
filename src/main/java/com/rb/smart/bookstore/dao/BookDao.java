package com.rb.smart.bookstore.dao;

import java.util.List;

import com.rb.smart.bookstore.entity.Book;

public interface BookDao {

	Book getBookByISBN(String isbn);

	Book addBook(Book book);

	List<Book> findAllBooksByIDs(List<Integer> list);

}
