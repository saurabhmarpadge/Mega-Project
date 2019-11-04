package com.megaproject.fallback;

import com.megaproject.client.BookClient;
import com.megaproject.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookClientFallback implements BookClient {

	@Override
	public ResponseEntity<Book> getBook(Long id) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

	@Override
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ArrayList<>());
	}

	@Override
	public ResponseEntity<Book> addBook(Book bookRequest) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

	@Override
	public ResponseEntity<Book> updateBook(Book bookRequest) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

	@Override
	public ResponseEntity<Object> deleteBook(Long id) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
	}

}