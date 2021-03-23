package com.rb.smart.bookstore.service;

import com.rb.smart.bookstore.entity.Amount;
import com.rb.smart.bookstore.entity.Cart;

public interface CheckoutService {

	Amount processCart(Cart requestCart);

}
