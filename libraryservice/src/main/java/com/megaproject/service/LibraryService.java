package com.megaproject.service;

import com.megaproject.entity.Library;
import com.megaproject.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public Library issueBook(Long bookId, Long userId) {
        Library library = Library.builder().bookId(bookId).userId(userId).build();
        return libraryRepository.save(library);
    }

}
