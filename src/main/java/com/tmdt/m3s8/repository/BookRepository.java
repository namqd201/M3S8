package com.tmdt.m3s8.repository;

import com.tmdt.m3s8.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
