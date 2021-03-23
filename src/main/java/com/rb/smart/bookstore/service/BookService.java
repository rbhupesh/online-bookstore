package com.rb.smart.bookstore.service;

import com.rb.smart.bookstore.entity.Book;

public interface BookService {

	Book getBookByISBN(String isbn);

	Book addBook(Book book);

}
