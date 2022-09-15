package com.demo.readingisgood.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EnumMessages {

    INTERNAL_SERVER_ERROR(1000, "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    BOOK_ATTRIBUTED_SAME(1001, "Book attribute same.", HttpStatus.BAD_REQUEST),
    DUPLICATE_BOOK_ERROR(1002, "Book not able to duplicated.", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}


