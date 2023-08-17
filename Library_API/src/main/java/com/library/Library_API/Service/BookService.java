package com.library.Library_API.Service;

import com.library.Library_API.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
        Book addBook(Book book);

        Book updateBook(Long id, Book book);

        void deleteBook(Long id);

        Book getBookById(Long id);

        List<Book> searchBooks(String title, String author, String isbn);
}

