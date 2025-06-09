package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByOnSaleTrue();

    public Book findByCode(String code);
}
