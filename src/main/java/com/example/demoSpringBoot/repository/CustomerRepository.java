package com.example.demoSpringBoot.repository;

import com.example.demoSpringBoot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer getById(String id);

    @Query("SELECT c FROM Customer c WHERE c.id LIKE %?1%")
    List<Customer> searchCustomerById(String keyword);
}
