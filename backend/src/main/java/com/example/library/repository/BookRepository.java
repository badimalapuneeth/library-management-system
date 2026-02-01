package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
