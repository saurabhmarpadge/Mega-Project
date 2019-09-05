package com.megaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private Long bookId;
    private String bookName;
    private String author;
    private Long isbn;
}
