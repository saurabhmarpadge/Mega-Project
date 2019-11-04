package com.megaproject.service.impl;

import com.megaproject.client.BookClient;
import com.megaproject.client.UserClient;
import com.megaproject.entity.Library;
import com.megaproject.model.Book;
import com.megaproject.model.User;
import com.megaproject.repository.LibraryRepository;
import com.megaproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("v2")
public class LibraryServiceImplFeignClient implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;


    @Autowired
    UserClient userClient;

    @Autowired
    BookClient bookClient;

    @Override
    public List<Book> getBooks() {
        return bookClient.getAllBooks().getBody();
    }

    @Override
    public Book getBook(Long bookId) {
        return bookClient.getBook(bookId).getBody();
    }

    @Override
    public Book addBook(Book book) {
       return bookClient.addBook(book).getBody();
    }

    @Override
    public void removeBook(Long bookId) {
        bookClient.deleteBook(bookId).getBody();
    }

    @Override
    public Book updateBook(Book book) {
        return bookClient.updateBook(book).getBody();
    }

    @Override
    public List<User> getUsers() {
        return userClient.getAllUsers().getBody();
    }

    @Override
    public User getUser(Long userId) {
        return userClient.getUser(userId).getBody();
    }

    @Override
    public User addUser(User user) {
        return userClient.addUser(user).getBody();
    }

    @Override
    public void removeUser(Long userId) {
        userClient.deleteUser(userId).getBody();
    }

    @Override
    public User updateUser(User user) {
        return userClient.updateUser(user).getBody();
    }

    @Override
    public Library issueBook(Long userId, Long bookId) {
        return  libraryRepository.save(Library.builder().userId(userId).bookId(bookId).build());
    }
}
