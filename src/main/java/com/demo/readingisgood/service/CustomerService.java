package com.demo.readingisgood.service;

import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.request.CreatingCustomerRequest;
import com.demo.readingisgood.request.UpdatingBookRequest;
import com.demo.readingisgood.request.UpdatingCustomerRequest;

import java.util.List;


public interface CustomerService {

    void createCustomer(CreatingCustomerRequest creatingCustomerRequest);

    void updateCustomer(UpdatingCustomerRequest updatingCustomerRequest) throws Exception;

    void deleteCustomer(long id) throws Exception;

    Customer getById(long id) throws Exception;

    void createCustomers(List<CreatingCustomerRequest> creatingCustomerRequest);

    void updateCustomers(List<UpdatingCustomerRequest> updatingCustomerRequests) throws Exception;


}

