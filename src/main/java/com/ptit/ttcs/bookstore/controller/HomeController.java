package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping("/")
//    public String getHomePage(){
//        return "index.html";
//    }
//
//    @RequestMapping("/user/create")
//    public void getCreateUserPage(){
//        User user = new User();
//        user.setFullname("Hung");
//        System.out.println(userService.saveUser(user));
//    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json" )
    public void createUser(@RequestBody User user) {
        System.out.println("Received User: " + user );
    }
}


