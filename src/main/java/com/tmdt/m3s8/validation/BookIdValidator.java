package com.tmdt.m3s8.validation;

import com.tmdt.m3s8.repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class BookIdValidator implements ConstraintValidator<ExistingBookId, Long> {

    private final BookRepository bookRepository;

    public BookIdValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isValid(Long bookId, ConstraintValidatorContext context) {

        if (bookId == null) {
            return false;
        }

        return bookRepository.existsById(bookId);
    }
}
