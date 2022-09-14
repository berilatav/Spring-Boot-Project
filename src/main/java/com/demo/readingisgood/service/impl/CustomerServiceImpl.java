package com.demo.readingisgood.service.impl;

import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.repository.CustomerRepository;
import com.demo.readingisgood.request.CreatingCustomerRequest;
import com.demo.readingisgood.request.UpdatingCustomerRequest;
import com.demo.readingisgood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(CreatingCustomerRequest creatingCustomerRequest) {
        Customer customer = new Customer();

        customer.setName(creatingCustomerRequest.getName());
        customer.setSurname(creatingCustomerRequest.getSurname());
        customer.setAddress(creatingCustomerRequest.getAddress());
        customer.setPhoneNumber(creatingCustomerRequest.getPhoneNumber());

        customerRepository.save(customer);
    }

    public void updateCustomer(UpdatingCustomerRequest updatingCustomerRequest) throws Exception {
        Customer updateCustomer = customerRepository.findById(updatingCustomerRequest.getId())
                .orElseThrow(() -> new Exception("Customer not exist with id: " + updatingCustomerRequest.getId()));

        updateCustomer.setName(updatingCustomerRequest.getName());
        updateCustomer.setSurname(updatingCustomerRequest.getSurname());
        updateCustomer.setAddress(updatingCustomerRequest.getAddress());
        updateCustomer.setPhoneNumber(updatingCustomerRequest.getPhoneNumber());

        customerRepository.save(updateCustomer);
    }

    public void deleteCustomer(long id) throws Exception {


        Customer deleteCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found with id: " + id));
        customerRepository.delete(deleteCustomer);
    }

    public Customer getById(long id) throws Exception {

        return customerRepository.findById(id)
                .orElseThrow(() -> new Exception("Customer not found with id: " + id));
    }

    public void createCustomers(List<CreatingCustomerRequest> creatingCustomerRequest ){
        for(CreatingCustomerRequest customer : creatingCustomerRequest) {
           createCustomer(customer);
        }
    }
    public void updateCustomers(List<UpdatingCustomerRequest> updatingCustomerRequest) throws Exception {
        List<Long> notUpdatedCustomers = new ArrayList<>();
        for (UpdatingCustomerRequest customer : updatingCustomerRequest) {
            try {
                updateCustomer(customer);

            } catch (Exception e) {
                notUpdatedCustomers.add(customer.getId());
            }
        }

        if (notUpdatedCustomers != null) {
            String notUpdatedBooksString = notUpdatedCustomers.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new Exception("The customers with this" + notUpdatedCustomers + "could not be updated.");
        }
    }
  }
