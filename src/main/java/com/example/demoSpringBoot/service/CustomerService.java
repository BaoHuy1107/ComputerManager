package com.example.demoSpringBoot.service;

import com.example.demoSpringBoot.model.Customer;
import com.example.demoSpringBoot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }

    public Customer getCustomerById(String id) {
        return this.customerRepository.getById(id);
    }

    public boolean existsByCustomerId(String id) {
        return customerRepository.existsById(id);
    }

    public List<Customer> searchCustomer(String keyword) {
        return this.customerRepository.searchCustomerById(keyword);
    }

}
