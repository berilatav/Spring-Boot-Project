package com.demo.readingisgood.repository;

import com.demo.readingisgood.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
