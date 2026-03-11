package com.tmdt.m3s8.controller;

import com.tmdt.m3s8.dto.BorrowCreateDTO;
import com.tmdt.m3s8.model.Borrow;
import com.tmdt.m3s8.service.BorrowService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public Borrow createBorrow(@Valid @RequestBody BorrowCreateDTO dto) {

        return borrowService.createBorrow(dto);
    }
}
