package com.demo.readingisgood.controller;

import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.request.CreatingCustomerRequest;
import com.demo.readingisgood.request.UpdatingCustomerRequest;
import com.demo.readingisgood.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer API Documentation")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @Operation(summary = "New Customer Adding Method")
    public void createCustomer(@RequestBody CreatingCustomerRequest creatingCustomerRequest) {
        customerService.createCustomer(creatingCustomerRequest);
    }

    @PutMapping
    @Operation(summary = "Customer Updating Method")
    public void updateCustomer(@RequestBody UpdatingCustomerRequest updatingCustomerRequest) throws Exception {
        customerService.updateCustomer(updatingCustomerRequest);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Customer Deleting Method")
    public void deleteCustomer(@PathVariable long id) throws Exception {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Customer With Id Method")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping("/list")
    @Operation(summary = "Create Customer List Method")
    public void createCustomers(@RequestBody List<CreatingCustomerRequest> creatingCustomerRequest) {
        customerService.createCustomers(creatingCustomerRequest);
    }

    @PutMapping("/update-list")
    @Operation(summary = "Update Customer List Method")
    public void updateCustomers(@RequestBody List<UpdatingCustomerRequest> updatingCustomerRequest) throws Exception{
        customerService.updateCustomers(updatingCustomerRequest);
    }
  }
