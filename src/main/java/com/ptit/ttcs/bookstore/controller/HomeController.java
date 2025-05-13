package com.ptit.ttcs.bookstore.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.DTO.CreateUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.EditUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;
import com.ptit.ttcs.bookstore.domain.Image;
import com.ptit.ttcs.bookstore.domain.Mapper.UserInfoMapper;
import com.ptit.ttcs.bookstore.domain.Mapper.UserInfoMapper;
import com.ptit.ttcs.bookstore.domain.Staff;
import com.ptit.ttcs.bookstore.domain.User;
import com.ptit.ttcs.bookstore.service.BookService;
import com.ptit.ttcs.bookstore.service.ImageService;
import com.ptit.ttcs.bookstore.service.StaffService;
import com.ptit.ttcs.bookstore.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class HomeController {

    private final UserService userService;
    private final StaffService staffService;
    private final ImageService imageService;
    private final UserInfoMapper userInfoMapper;

    public HomeController(UserService userService, StaffService staffService, ImageService imageService, UserInfoMapper userInfoMapper) {
        this.userService = userService;
        this.staffService = staffService;
        this.imageService = imageService;
        this.userInfoMapper = userInfoMapper;
    }

    @RequestMapping("/")
    public String getHomePage(){
        return "index.html";
    }


    @PostMapping("/user/create")
    public void createUser(@RequestPart("userInput") CreateUserDTO createUserDTO, @RequestPart("inputImg") MultipartFile inputImg) throws IOException {
        System.out.println(inputImg.getOriginalFilename() + " " + createUserDTO);
        User newUser = userService.saveUser(UserInfoMapper.INSTANCE.CreateUserDTOToUser(createUserDTO));

        String fileName = inputImg.getOriginalFilename();
        String fileType = inputImg.getContentType();
        byte[] data = inputImg.getBytes();

        Image image = new Image();
        image.setData(data);
        image.setType(fileType);

        Image new_img = imageService.saveImg(image);
        newUser.setImage(new_img);
        userService.saveUser(newUser);
    }

    @PostMapping("/user/edit")
    public void editUser(@RequestPart("userData") EditUserDTO editUserDTO, @RequestPart("imgData") MultipartFile imgData) throws IOException
    {

        System.out.println(editUserDTO);
        User existUser = userService.findUserById(editUserDTO.getId());
        existUser.setFullname(editUserDTO.getFullname());
        existUser.setEmail(editUserDTO.getEmail());
        existUser.setPassword(editUserDTO.getPassword());
        existUser.setAge(editUserDTO.getAge());
        existUser.setAddress(editUserDTO.getAddress());
        existUser.setPhone(editUserDTO.getPhone());
        existUser.setGender(editUserDTO.getGender());

        Image existImg = existUser.getImage();
        existImg.setData(imgData.getBytes());
        existImg.setType(imgData.getContentType());

        userService.saveUser(existUser);
        imageService.saveImg(existImg);

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
        GetUserDTO temp = UserInfoMapper.INSTANCE.userToGetUserDTO(userService.findUserById(id));
        return temp;
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


