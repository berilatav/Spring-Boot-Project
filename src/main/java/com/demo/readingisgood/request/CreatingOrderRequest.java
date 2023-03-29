package com.demo.readingisgood.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatingOrderRequest {

   private Long customerId;
   private Long bookId;
   private int quantity;

}
