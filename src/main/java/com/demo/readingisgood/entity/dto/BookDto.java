package com.demo.readingisgood.entity.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookDto implements Serializable {

    private long id;
    private String name;
    private String author;
    private long quantity;
}
