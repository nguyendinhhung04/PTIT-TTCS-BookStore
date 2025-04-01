package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(){
        return "index.html";
    }


    @PostMapping(value = "/user/create", consumes = "application/json", produces = "application/json" )
    public void createUser(@RequestBody User user) {
        System.out.println("Received User: " + user );
        userService.saveUser(user);
    }

    @GetMapping("/admin/user/view")
    public List<User> viewUser() {
        System.out.println("Access form frontend");
        return userService.findAllUser();
    }

    @GetMapping("/admin/user/detail/{id}")
    public User  viewDetailUser(@PathVariable("id") Long id) {
        System.out.println(id);
        System.out.println(userService.findUserById(id));
        return userService.findUserById(id);

    }



}


