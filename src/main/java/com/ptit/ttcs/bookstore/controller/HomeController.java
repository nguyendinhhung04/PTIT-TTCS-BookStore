package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(){
        return "index.html";
    }


    @CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
    @RequestMapping("/user/create")
    public void getCreateUserPage(){
        User user = new User();
        user.setFullname("Hung");
        System.out.println(userService.saveUser(user));
    }

}


