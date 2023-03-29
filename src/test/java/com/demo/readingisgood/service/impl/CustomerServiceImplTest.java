package com.demo.readingisgood.service.impl;

import com.demo.readingisgood.repository.CustomerRepository;
import com.demo.readingisgood.service.util.MockRequestModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerServiceImpl customerService;

    private MockRequestModel mockRequestModel = new MockRequestModel();

    @Test
    public void test_update_customer() throws Exception {

    }

}