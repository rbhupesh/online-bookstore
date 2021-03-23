package com.rb.smart.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rb.smart.bookstore.cache.CacheManager;
import com.rb.smart.bookstore.dao.BookDao;
import com.rb.smart.bookstore.entity.Amount;
import com.rb.smart.bookstore.entity.Book;
import com.rb.smart.bookstore.entity.Cart;
import com.rb.smart.bookstore.service.CheckoutService;



@SpringBootTest
class CheckoutServiceTests {
	
	@MockBean
	private BookDao bookDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private CheckoutService checkoutService;

	@Test
	void processCart1() {	
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		Cart requestCart = new Cart();
		requestCart.setBooks(list);
		
		Book book = new Book();
		book.setId(1);
		book.setISBN("ISBN1");
		book.setClassification("COMIC");
		book.setPrice(10.0f);
		List<Book> books = new ArrayList<>();
		books.add(book);
		
		given(this.bookDao.findAllBooksByIDs(list)).willReturn(books);
			
		Amount amount = checkoutService.processCart(requestCart);
		
		assertThat(amount.getTotal()).isEqualTo(10.0f);		
	}
	
	@Test
	void processCart2() {	
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		Cart requestCart = new Cart();
		requestCart.setBooks(list);
		
		Book book = new Book();
		book.setId(1);
		book.setISBN("ISBN1");
		book.setClassification("FICTION");
		book.setPrice(10.0f);
		List<Book> books = new ArrayList<>();
		books.add(book);
		
		given(this.bookDao.findAllBooksByIDs(list)).willReturn(books);
			
		Amount amount = checkoutService.processCart(requestCart);
		
		assertThat(amount.getTotal()).isEqualTo(9.0f);		
	}	
}
