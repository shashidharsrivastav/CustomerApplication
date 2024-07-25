package com.hospitalManagement.customer.entity;

import com.hospitalManagement.customer.Customer;
import jakarta.persistence.Lob;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer,Lob> {
   public Customer findByid(int id);
//   Optional<Customer> findByName(String name);
}