package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.repository.CustomerRepository;
import com.ptit.ttcs.bookstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    //Inject dependency into class by constructor
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllUser() {
        return this.customerRepository.findAll();
    }

    public Customer findUserById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    public Customer saveUser(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }
}
