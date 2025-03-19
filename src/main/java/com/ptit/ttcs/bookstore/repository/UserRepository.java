package com.ptit.ttcs.bookstore.repository;

import java.util.*;

import com.ptit.ttcs.bookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
