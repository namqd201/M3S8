package com.tmdt.m3s8.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateStockDTO {
    @Min(value = 0, message = "Stock must be >= 0")
    private Integer stock;
}
