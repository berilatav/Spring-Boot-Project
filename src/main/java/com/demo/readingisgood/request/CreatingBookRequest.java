package com.demo.readingisgood.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatingBookRequest {

    private String name;
    private String author;
    private long quantity;

}
