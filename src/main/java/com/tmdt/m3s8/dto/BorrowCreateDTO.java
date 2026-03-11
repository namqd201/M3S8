package com.tmdt.m3s8.dto;

import com.tmdt.m3s8.validation.ExistingBookId;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BorrowCreateDTO {
    @NotBlank(message = "Username không được để trống")
    private String username;

    @ExistingBookId
    private Long bookId;
}
