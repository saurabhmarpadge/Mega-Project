package com.megaproject.client;

import com.megaproject.fallback.BookClientFallback;
import com.megaproject.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${bookservice.name}", fallback = BookClientFallback.class)
public interface BookClient {

	@GetMapping(value =  "/book-service/books/{book_id}")
	ResponseEntity<Book> getBook(@PathVariable(value = "book_id") Long id);

	@GetMapping(value = "/book-service/books")
	ResponseEntity<List<Book>> getAllBooks();

	@PostMapping(value = "/book-service/books")
	ResponseEntity<Book> addBook(@RequestBody Book bookRequest);

	@PutMapping(value = "/book-service/books")
	ResponseEntity<Book> updateBook(@RequestBody Book bookRequest);

	@DeleteMapping(value = "/book-service/books/{book_id}")
	ResponseEntity<Object> deleteBook(@PathVariable(value = "book_id") Long id);

}