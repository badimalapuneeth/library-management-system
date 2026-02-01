package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    // ✅ REQUIRED FOR DELETE
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }

    // ✅ REQUIRED FOR UPDATE
    public Book updateCopies(Long id, int copies) {
        Book book = repo.findById(id).orElseThrow();
        book.setCopies(copies);
        return repo.save(book);
    }
}
