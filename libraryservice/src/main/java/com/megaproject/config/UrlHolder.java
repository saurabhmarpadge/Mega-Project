package com.megaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UrlHolder {
    public String bookUrl;
    public String userUrl;
    public String bookId;
    public String userId;

    UrlHolder(){
        this.bookUrl = "http://localhost:8180/book-service/books";
        this.userUrl = "http://localhost:8181/user-service/users";
        this.bookId = this.bookUrl+"/{book_id}";
        this.userId = this.userUrl+"/{user_id}";
    }

}
