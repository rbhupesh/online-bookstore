package com.rb.smart.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rb.smart.bookstore.cache.CacheManager;
import com.rb.smart.bookstore.cache.CacheManagerImpl;
import com.rb.smart.bookstore.dao.BookDao;
import com.rb.smart.bookstore.dao.BookDaoImpl;
import com.rb.smart.bookstore.service.BookService;
import com.rb.smart.bookstore.service.BookServiceImpl;
import com.rb.smart.bookstore.service.CheckoutService;
import com.rb.smart.bookstore.service.CheckoutServiceImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(title = "BookStore service API",
					version = "1.0",
					description = "BookStore service provide api interface for buying books"),
		servers = @Server(url = "https://www.rb-parking.com",
					description = "spring-boot internal tomcat server is in use")
		)
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.rb.smart.bookstore.dao.repo")
public class BookstoreApplication {

	/*
	 * localhost url
	 * http://localhost:8080/v3/api-docs/
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public BookService bookService(){
		return new BookServiceImpl();
	}
	
	@Bean
	public BookDao bookDao(){
		return new BookDaoImpl();
	}
	
	@Bean
	public CheckoutService checkoutService(){
		return new CheckoutServiceImpl();
	}
	
	@Bean
	public CacheManager cacheManager(){
		return new CacheManagerImpl();
	}
	
	
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("BookStore Service Started");
		};
	}

}
