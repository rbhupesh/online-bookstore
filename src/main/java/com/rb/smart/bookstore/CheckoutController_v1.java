package com.rb.smart.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rb.smart.bookstore.entity.Amount;
import com.rb.smart.bookstore.entity.Cart;
import com.rb.smart.bookstore.service.CheckoutService;

/*
 * 
 * we need to implement add to basket api before checkout api is called.
 * also we need to check the current stock as well.
 */
@RestController
public class CheckoutController_v1 {
	
	@Autowired
	private CheckoutService checkoutService;
		
	@PostMapping("/api/v1/book-store/checkout")
	public HttpEntity<Amount> checkoutBooks(@RequestBody Cart requestCart) {
		System.out.println("CheckoutController_v1.checkoutBooks @RequestBody : "+requestCart.toString());
		
		Amount amount = checkoutService.processCart(requestCart);
		ResponseEntity<Amount> response = new ResponseEntity<Amount>(amount, HttpStatus.OK);
		
		System.out.println("ResponseEntity : "+response.toString());
		return response;		
	}
	
}
