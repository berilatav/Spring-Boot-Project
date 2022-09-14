package com.demo.readingisgood.service.impl;

import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.entity.Order;
import com.demo.readingisgood.repository.BookRepository;
import com.demo.readingisgood.repository.CustomerRepository;
import com.demo.readingisgood.repository.OrderRepository;
import com.demo.readingisgood.request.CreatingOrderRequest;
import com.demo.readingisgood.request.UpdatingOrderRequest;
import com.demo.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    public void createOrder(CreatingOrderRequest creatingOrderRequest) throws Exception {
        Order order = new Order();

        Book book = bookRepository.findById(creatingOrderRequest.getBookId())
                .orElseThrow(() -> new Exception("Book not exist with id: " + creatingOrderRequest.getBookId()));
        long bookCount = book.getQuantity();
        if (book.getQuantity() >= creatingOrderRequest.getQuantity()) {
            order.setBook(book);
            Customer customer = customerRepository.findById(creatingOrderRequest.getCustomerId())
                    .orElseThrow(() -> new Exception("Customer not exist with id: " + creatingOrderRequest.getCustomerId()));
            order.setCustomer(customer);
            order.setQuantity(creatingOrderRequest.getQuantity());

            orderRepository.save(order);
            book.setQuantity(book.getQuantity() - creatingOrderRequest.getQuantity());
            bookRepository.save(book);
        }
        else {
            order.setBook(book);
            Customer customer = customerRepository.findById(creatingOrderRequest.getCustomerId())
                    .orElseThrow(() -> new Exception("Customer not exist with id: " + creatingOrderRequest.getCustomerId()));
            order.setCustomer(customer);
            order.setQuantity((int) bookCount);

            orderRepository.save(order);
            book.setQuantity(0);
            bookRepository.save(book);
            throw new RuntimeException("Only " + bookCount + " book order received." + Math.abs(bookCount - creatingOrderRequest.getQuantity()) + " book will be provided.");
        }
    }

    public void updateOrder(UpdatingOrderRequest updatingOrderRequest) throws Exception {
        Order updateOrder = orderRepository.findById(updatingOrderRequest.getId())
                .orElseThrow(() -> new Exception("Order not exist with id: " + updatingOrderRequest.getId()));


        Book book = bookRepository.findById(updatingOrderRequest.getBookId())
                .orElseThrow(() -> new Exception("Book not exist with id: " + updatingOrderRequest.getBookId()));
        updateOrder.setBook(book);

        Customer customer = customerRepository.findById(updatingOrderRequest.getCustomerId())
                .orElseThrow(() -> new Exception("Customer not exist with id: " + updatingOrderRequest.getCustomerId()));
        updateOrder.setCustomer(customer);
        updateOrder.setQuantity(updatingOrderRequest.getQuantity());

        orderRepository.save(updateOrder);
    }
    public void deleteOrder(long id) throws Exception {


        Order deleteOrder = orderRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found with id: " + id));
        orderRepository.delete(deleteOrder);
    }
    public Order getById(long id) throws Exception {

        return orderRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found with id: " + id));
    }
}
