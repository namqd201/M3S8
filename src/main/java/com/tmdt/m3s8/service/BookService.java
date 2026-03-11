package com.tmdt.m3s8.service;

import com.tmdt.m3s8.dto.BookCreateDTO;
import com.tmdt.m3s8.dto.BookUpdateStockDTO;
import com.tmdt.m3s8.exception.ResourceNotFoundException;
import com.tmdt.m3s8.model.Book;
import com.tmdt.m3s8.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private static final String UPLOAD_DIR = "uploads/";

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookCreateDTO dto) throws IOException {

        MultipartFile file = dto.getCoverImage();

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        File uploadPath = new File(UPLOAD_DIR);

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        File destination = new File(UPLOAD_DIR + fileName);

        file.transferTo(destination);

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setStock(dto.getStock());
        book.setCoverUrl(fileName);

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookUpdateStockDTO dto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));

        book.setStock(dto.getStock());

        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {

        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));
    }
}
