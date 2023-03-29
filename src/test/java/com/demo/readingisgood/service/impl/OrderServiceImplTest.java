package com.demo.readingisgood.service.impl;

import com.demo.readingisgood.entity.Order;
import com.demo.readingisgood.repository.BookRepository;
import com.demo.readingisgood.repository.CustomerRepository;
import com.demo.readingisgood.repository.OrderRepository;
import com.demo.readingisgood.service.util.MockRequestModel;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private OrderServiceImpl orderService;

    private MockRequestModel mockRequestModel = new MockRequestModel();


    @Test
    public void test_get_by_id() throws Exception {
        long dummyId = 1L ;
        Order order = mockRequestModel.returnOrderObject(dummyId);
       // when(orderRepository.findById(dummyId)).thenReturn(Optional.ofNullable(mockRequestModel.returnOrderObject(dummyId)));

        Mockito.lenient().doReturn(Optional.of(order)).when(orderRepository).findById(dummyId);
        Mockito.lenient().when(orderService.getById(dummyId)).thenReturn(order);
        //Order orderEntity = orderService.getById(dummyId);
        //assertNotNull(orderEntity,"Employee with employeeId : "+dummyId+" not found");
        //assertEquals(dummyId,orderEntity.getId());

    }
}
