package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.library.entity.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }
    @DeleteMapping("/{id}")
public void deleteBook(@PathVariable Long id) {
    service.deleteBook(id);
}
@PutMapping("/{id}")
public Book updateBookCopies(@PathVariable Long id, @RequestParam int copies) {
    return service.updateCopies(id, copies);
}

}
