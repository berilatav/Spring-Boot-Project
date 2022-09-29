package com.demo.readingisgood.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookDto {

    private long id;
    private String name;
    private String author;
    private long quantity;
}
