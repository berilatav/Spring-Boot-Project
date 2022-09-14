package com.demo.readingisgood.controller;

import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.entity.Order;
import com.demo.readingisgood.request.CreatingOrderRequest;
import com.demo.readingisgood.request.UpdatingOrderRequest;
import com.demo.readingisgood.service.OrderService;
import com.demo.readingisgood.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody CreatingOrderRequest creatingOrderRequest) throws Exception {
        orderService.createOrder(creatingOrderRequest);
    }

    @PutMapping
    public void updateOrder(@RequestBody UpdatingOrderRequest updatingOrderRequest) throws Exception {
        orderService.updateOrder(updatingOrderRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) throws Exception {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderService.getById(id));
    }
}
