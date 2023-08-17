package com.library.Library_API.Service;

import com.library.Library_API.Model.Book;
import com.library.Library_API.Repository.BookRepository;
import com.library.Library_API.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublicationYear(book.getPublicationYear());
            return bookRepository.save(existingBook);
        } else {
            throw new BookNotFoundException("Book not found with ID: " + id);
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
    }

    @Override
    public List<Book> searchBooks(String title, String author, String isbn) {
        // Implement the search logic using the BookRepository
        // You can use methods like bookRepository.findByTitleContainingIgnoreCase(title)
        // to perform searches based on criteria
        return null; // Implement this
    }
}
