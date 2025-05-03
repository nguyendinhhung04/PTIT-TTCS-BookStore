package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
