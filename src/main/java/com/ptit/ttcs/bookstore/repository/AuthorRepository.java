package com.ptit.ttcs.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.ttcs.bookstore.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
