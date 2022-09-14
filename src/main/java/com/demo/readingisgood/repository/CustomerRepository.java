package com.demo.readingisgood.repository;

import com.demo.readingisgood.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

   List<Customer> findByNameAndSurname(String name, String surname);
}
