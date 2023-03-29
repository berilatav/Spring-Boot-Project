package com.demo.readingisgood.service.util;

import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.entity.Order;

import java.time.LocalDateTime;
import java.util.Random;

public class MockRequestModel {

    public Order returnOrderObject(long id) {
        Order order = new Order();
        order.setId(id);
        order.setQuantity(10);
        order.setCustomer(returnCustomerObject());
        order.setBook(returnBookObject());
        order.setCreatedDate(LocalDateTime.now());
        order.setLastModifiedDate(LocalDateTime.now());

        return order;

    }

    public Customer returnCustomerObject() {
        Customer customer = new Customer();
        customer.setId(new Random().nextLong());
        customer.setName("Deneme İsim");
        customer.setSurname("Deneme Soyisim");
        customer.setPhoneNumber("Deneme TelNo");
        customer.setAddress("Deneme Adres");
        customer.setCreatedDate(LocalDateTime.now());
        customer.setLastModifiedDate(LocalDateTime.now());

        return customer;
    }

    public Book returnBookObject() {
        Book book = new Book();
        book.setId(new Random().nextLong());
        book.setAuthor("Deneme Yazar");
        book.setQuantity(12);
        book.setCreatedDate(LocalDateTime.now());
        book.setLastModifiedDate(LocalDateTime.now());

        return book;
    }
}

