package com.rb.smart.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rb.smart.bookstore.dao.BookDao;
import com.rb.smart.bookstore.entity.Book;
import com.rb.smart.bookstore.service.BookService;

@SpringBootTest
class BookServiceTests {

	@MockBean
	private BookDao bookDao;

	@Autowired
	private BookService bookService;

	@Test
	void getBookByISBN() {
		Book book = new Book();
		book.setId(1);
		book.setISBN("ISBN1");

		given(this.bookDao.getBookByISBN("ISBN1")).willReturn(book);

		Book returnedBook =  bookService.getBookByISBN("ISBN1");

		assertThat(returnedBook.getId()).isEqualTo(book.getId());
		assertThat(returnedBook.getISBN()).isEqualTo(book.getISBN());
	}

	@Test
	void addBook() {
		Book book = new Book();
		book.setISBN("ISBN1");
		
		given(this.bookDao.addBook(book)).willReturn(book);
		
		Book returnedBook =  bookService.addBook(book);;

		assertThat(returnedBook.getISBN()).isEqualTo(book.getISBN());
	}
}
