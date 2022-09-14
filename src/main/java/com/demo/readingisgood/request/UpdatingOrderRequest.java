package com.demo.readingisgood.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatingOrderRequest {

    private long id;
    private Long customerId;
    private Long bookId;
    private int quantity;

}
