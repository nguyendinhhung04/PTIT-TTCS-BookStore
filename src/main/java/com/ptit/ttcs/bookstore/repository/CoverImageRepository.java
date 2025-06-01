package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.CoverImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverImageRepository extends JpaRepository<CoverImage, Long> {
}
