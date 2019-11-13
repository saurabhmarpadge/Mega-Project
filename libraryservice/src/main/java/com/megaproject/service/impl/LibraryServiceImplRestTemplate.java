package com.megaproject.service.impl;

import com.megaproject.config.UrlHolder;
import com.megaproject.entity.Library;
import com.megaproject.model.Book;
import com.megaproject.model.User;
import com.megaproject.repository.LibraryRepository;
import com.megaproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("v1")
public class LibraryServiceImplRestTemplate implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlHolder urlHolder;

    @Override
    public List<Book> getBooks() {
        return Arrays.asList(restTemplate.exchange(urlHolder.bookUrl,HttpMethod.GET, null, Book[].class).getBody());
    }

    @Override
    public Book getBook(Long bookId) {
        return restTemplate.exchange(urlHolder.bookUrl + "/" + bookId, HttpMethod.GET, null, Book.class).getBody();

    }

    @Override
    public Book addBook(Book book) {
        return restTemplate.exchange(urlHolder.bookUrl, HttpMethod.POST, new HttpEntity<>(book), Book.class).getBody();
    }

    @Override
    public void removeBook(Long bookId) {
        restTemplate.exchange(urlHolder.userUrl + "/" + bookId, HttpMethod.DELETE, null, Long.class).getBody();
    }

    @Override
    public Book updateBook(Book book) {
        return restTemplate.exchange(urlHolder.bookUrl, HttpMethod.POST, new HttpEntity<>(book), Book.class).getBody();
    }

    @Override
    public List<User> getUsers() {
        return Arrays.asList(restTemplate.exchange(urlHolder.userUrl, HttpMethod.GET, null, User[].class).getBody());
    }

    @Override
    public User getUser(Long userId) {
        return restTemplate.exchange(urlHolder.userUrl + "/" + userId, HttpMethod.GET, null, User.class).getBody();
    }

    @Override
    public User addUser(User user) {
        return restTemplate.exchange(urlHolder.userUrl, HttpMethod.POST, new HttpEntity<>(user), User.class).getBody();
    }

    @Override
    public void removeUser(Long userId) {
        restTemplate.exchange(urlHolder.userUrl + "/" + userId, HttpMethod.DELETE, null, Long.class).getBody();
    }

    @Override
    public User updateUser(User user) {
        return restTemplate.exchange(urlHolder.userUrl, HttpMethod.PUT, new HttpEntity<>(user), User.class).getBody();
    }

    @Override
    public Library issueBook(Long userId, Long bookId) {
        return  libraryRepository.save(Library.builder().userId(userId).bookId(bookId).build());
    }
}
