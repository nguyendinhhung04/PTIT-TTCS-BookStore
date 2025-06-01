package com.ptit.ttcs.bookstore.repository;

import com.ptit.ttcs.bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
