package com.demo.readingisgood.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatingCustomerRequest {

    private long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;

}
