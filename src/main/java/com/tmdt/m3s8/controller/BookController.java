package com.tmdt.m3s8.controller;

import com.tmdt.m3s8.dto.BookCreateDTO;
import com.tmdt.m3s8.dto.BookUpdateStockDTO;
import com.tmdt.m3s8.model.Book;
import com.tmdt.m3s8.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@ModelAttribute BookCreateDTO dto) throws Exception {

        return bookService.createBook(dto);
    }

    @PatchMapping("/update/{id}")
    public Book updateBookStock(
            @PathVariable Long id,
            @Valid @RequestBody BookUpdateStockDTO dto) {

        return bookService.updateBook(id, dto);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
}
