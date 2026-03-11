package com.tmdt.m3s8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDTO  {
    private String title;

    private String author;

    private Integer stock;

    private MultipartFile coverImage;
}
