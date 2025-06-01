package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
