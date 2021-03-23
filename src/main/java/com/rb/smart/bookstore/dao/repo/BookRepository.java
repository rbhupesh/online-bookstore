package com.rb.smart.bookstore.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rb.smart.bookstore.entity.Book;

/*
 * @Repository RestResource(collectionResourceRel = "bookings", path = "bookings")
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("SELECT b FROM Book b WHERE LOWER(b.ISBN) = LOWER(:isbn)")
	Book findByISBN(String isbn);

}
