package com.ptit.ttcs.bookstore.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.DTO.CreateUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;
import com.ptit.ttcs.bookstore.domain.Image;
import com.ptit.ttcs.bookstore.domain.Mapper.UserInfoMapper;
import com.ptit.ttcs.bookstore.domain.Mapper.UserInfoMapper;
import com.ptit.ttcs.bookstore.domain.Staff;
import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.service.BookService;
import com.ptit.ttcs.bookstore.service.StaffService;
import com.ptit.ttcs.bookstore.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class HomeController {

    private final UserService userService;
    private final StaffService staffService;


    public HomeController(UserService userService, StaffService staffService) {
        this.userService = userService;
        this.staffService = staffService;
    }

    @RequestMapping("/")
    public String getHomePage(){
        return "index.html";
    }


    @PostMapping("/user/create")
    public void createUser(@RequestPart("userInput") CreateUserDTO createUserDTO, @RequestPart("inputImg") MultipartFile inputImg) {
        System.out.println(inputImg.getOriginalFilename() + " " + createUserDTO);
    }

    @PostMapping("user/uploadImg/{id}")
    public void getUserImg(@RequestPart("inputImg") MultipartFile inputImg, @PathVariable("id") Long id) {
        System.out.println(inputImg.getOriginalFilename());
        System.out.println(id);
    }


    @GetMapping("/admin/user/view")
    public List<GetUserDTO> viewUser() {
        List<User> userList = userService.findAllUser();
        return userList.stream().map(UserInfoMapper.INSTANCE::userToGetUserDTO ).collect(Collectors.toList());
    }

    @GetMapping("/admin/user/detail/{id}")
    public GetUserDTO viewDetailUser(@PathVariable("id") Long id) {
        return (UserInfoMapper.INSTANCE.userToGetUserDTO(userService.findUserById(id)));
    }

    @PostMapping("/admin/user/delete/{id}")
    public void  deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/admin/staff/view")
    public List<Staff> viewStaff() {
        return staffService.findAll();
    }

}


