package com.demo.readingisgood.service;

import com.demo.readingisgood.entity.Order;
import com.demo.readingisgood.request.CreatingOrderRequest;
import com.demo.readingisgood.request.UpdatingOrderRequest;



import java.util.List;


public interface OrderService {

    public void createOrder(CreatingOrderRequest creatingOrderRequest) throws Exception;

    public void updateOrder(UpdatingOrderRequest updatingOrderRequest) throws Exception;

    public void deleteOrder(long id) throws Exception;

    Order getById(long id) throws Exception;

}

