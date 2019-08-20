package com.megaproject.dto;

import lombok.Data;

@Data
public class BookRequest {
    private Long bookId;
    private String bookName;
    private String author;
    private Long isbn;
}
