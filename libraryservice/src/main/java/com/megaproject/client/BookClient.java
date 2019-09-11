package com.megaproject.client;

import com.megaproject.fallback.BookClientFallback;
import com.megaproject.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${service.name.book}", fallback = BookClientFallback.class)
public interface BookClient {
	@GetMapping("/book-service/books")
	public List<Book> getAllBooks();
}