package com.ptit.ttcs.bookstore.service;


import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    //Inject dependency into class by constructor
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }
}
