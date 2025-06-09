package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
