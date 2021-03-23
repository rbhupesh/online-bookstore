package com.rb.smart.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rb.smart.bookstore.entity.Book;
import com.rb.smart.bookstore.service.BookService;

@RestController
public class BooksController_v1 {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/api/v1/book-store/books/{isbn}")
	public HttpEntity<Book> getBooksById(
			@PathVariable("isbn") String isbn) {
				
		Book book = bookService.getBookByISBN(isbn);
		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.OK);
		
		System.out.println("ResponseEntity : "+response.toString());
		return response;		
	}
	
	@PostMapping("/api/v1/book-store/books")
	public HttpEntity<Book> addBook(@RequestBody Book requestBook) {
		System.out.println("BooksController_v1.addBook @RequestBody : "+requestBook.toString());
		
		Book book = bookService.addBook(requestBook);
		ResponseEntity<Book> response = new ResponseEntity<Book>(requestBook, HttpStatus.OK);
		
		System.out.println("ResponseEntity : "+response.toString());
		return response;		
	}	
}
