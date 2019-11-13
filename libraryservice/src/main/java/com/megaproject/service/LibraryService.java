package com.megaproject.service;

import com.megaproject.entity.Library;
import com.megaproject.model.Book;
import com.megaproject.model.User;

import java.util.List;

public interface LibraryService {

	public List<Book> getBooks();

	public Book getBook(Long bookId);

	public Book addBook(Book book);

	public void removeBook(Long bookId);

	public Book updateBook(Book book);

	public List<User> getUsers();

	public User getUser(Long userId);

	public User addUser(User user);

	public void removeUser(Long userId);

	public User updateUser(User user);

	public Library issueBook(Long userId, Long bookId);
}
