package com.demo.readingisgood.controller;

import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.entity.Order;
import com.demo.readingisgood.request.CreatingOrderRequest;
import com.demo.readingisgood.request.UpdatingOrderRequest;
import com.demo.readingisgood.service.OrderService;
import com.demo.readingisgood.service.impl.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Tag(name ="Order API Documentation")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Operation(summary = "New Order Adding Method")
    public void createOrder(@RequestBody CreatingOrderRequest creatingOrderRequest) throws Exception {
        orderService.createOrder(creatingOrderRequest);
    }

    @PutMapping
    @Operation(summary = "Order Updating Method")
    public void updateOrder(@RequestBody UpdatingOrderRequest updatingOrderRequest) throws Exception {
        orderService.updateOrder(updatingOrderRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Order Deleting Method")
    public void deleteOrder(@PathVariable long id) throws Exception {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Order With Id Method")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(orderService.getById(id));
    }
}
