package com.tmdt.m3s8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "borrows")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private Long bookId;

    public  Borrow(String username,Long bookId) {
        this.username = username;
        this.bookId = bookId;
    }
}
