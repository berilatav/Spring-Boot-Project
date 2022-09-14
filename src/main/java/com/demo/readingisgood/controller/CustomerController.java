package com.demo.readingisgood.controller;

import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.request.CreatingBookRequest;
import com.demo.readingisgood.request.CreatingCustomerRequest;
import com.demo.readingisgood.request.UpdatingBookRequest;
import com.demo.readingisgood.request.UpdatingCustomerRequest;
import com.demo.readingisgood.service.CustomerService;
import com.demo.readingisgood.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void createCustomer(@RequestBody CreatingCustomerRequest creatingCustomerRequest) {
        customerService.createCustomer(creatingCustomerRequest);
    }

    @PutMapping
    public void updateCustomer(@RequestBody UpdatingCustomerRequest updatingCustomerRequest) throws Exception {
        customerService.updateCustomer(updatingCustomerRequest);

    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id) throws Exception {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping("/list")
    public void createCustomers(@RequestBody List<CreatingCustomerRequest> creatingCustomerRequest) {
        customerService.createCustomers(creatingCustomerRequest);
    }

    @PutMapping("/update-list")
    public void updateCustomers(@RequestBody List<UpdatingCustomerRequest> updatingCustomerRequest) throws Exception{
        customerService.updateCustomers(updatingCustomerRequest);
    }
  }
