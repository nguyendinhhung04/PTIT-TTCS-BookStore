package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {



}
