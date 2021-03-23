package com.rb.smart.bookstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.rb.smart.bookstore.cache.CacheManager;
import com.rb.smart.bookstore.dao.BookDao;
import com.rb.smart.bookstore.entity.Amount;
import com.rb.smart.bookstore.entity.Book;
import com.rb.smart.bookstore.entity.Cart;

public class CheckoutServiceImpl implements CheckoutService {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private CacheManager cacheManager;

	@Override
	public Amount processCart(Cart requestCart) {
		
		List<Integer> list = requestCart.getBooks();
		
		List<Book> books = bookDao.findAllBooksByIDs(list);
		
		float totalAmount = 0.0f;
		float bookAmount = 0.0f;
		float tempAmount = 0.0f;
		
		Map<String, Integer> discountMap = (Map<String, Integer>) cacheManager.getCachedObj("DISCOUNT");
		
		for (Book book : books) {
			bookAmount = book.getPrice();
			int discount  = discountMap.get(book.getClassification());
			
			tempAmount = bookAmount -  bookAmount*discount/100.0f;
			totalAmount += tempAmount; 			
		}
		
		Amount amount = new Amount();
		amount.setTotal(totalAmount);
		return amount;
	}
}
