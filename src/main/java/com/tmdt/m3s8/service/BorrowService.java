package com.tmdt.m3s8.service;

import com.tmdt.m3s8.dto.BorrowCreateDTO;
import com.tmdt.m3s8.model.Borrow;
import com.tmdt.m3s8.repository.BorrowRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public Borrow createBorrow(BorrowCreateDTO dto) {

        Borrow borrow = new Borrow(
                dto.getUsername(),
                dto.getBookId()
        );

        return borrowRepository.save(borrow);
    }
}
