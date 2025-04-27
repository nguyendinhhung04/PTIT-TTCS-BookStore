package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.Compose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComposeRepository extends JpaRepository<Compose, Long> {



}
