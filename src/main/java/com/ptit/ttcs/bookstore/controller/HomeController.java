package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.domain.DTO.CreateUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.EditUserDTO;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.UserInfoMapper;
import com.ptit.ttcs.bookstore.domain.Staff;
import com.ptit.ttcs.bookstore.service.StaffService;
import com.ptit.ttcs.bookstore.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class HomeController {

    private final CustomerService customerService;
    private final StaffService staffService;
    private final UserInfoMapper userInfoMapper;

    public HomeController(CustomerService customerService, StaffService staffService,  UserInfoMapper userInfoMapper) {
        this.customerService = customerService;
        this.staffService = staffService;
        this.userInfoMapper = userInfoMapper;
    }

    @RequestMapping("/")
    public String getHomePage(){
        return "index.html";
    }


    @PostMapping("/user/create")
    public void createUser(@RequestPart("userInput") CreateUserDTO createUserDTO) throws IOException {
        Customer newCustomer = customerService.saveUser(UserInfoMapper.INSTANCE.CreateUserDTOToUser(createUserDTO));
        customerService.saveUser(newCustomer);
    }

    @PostMapping("/user/edit")
    public void editUser(@RequestPart("userData") EditUserDTO editUserDTO) throws IOException
    {
        Customer existCustomer = customerService.findUserById(editUserDTO.getId());
        existCustomer.setFullname(editUserDTO.getFullname());
        existCustomer.setEmail(editUserDTO.getEmail());
        existCustomer.setAge(editUserDTO.getAge());
        existCustomer.setAddress(editUserDTO.getAddress());
        existCustomer.setPhone(editUserDTO.getPhone());
        existCustomer.setGender(editUserDTO.getGender());
        customerService.saveUser(existCustomer);
    }

//    @PostMapping("user/uploadImg/{id}")
//    public void getUserImg(@RequestPart("inputImg") MultipartFile inputImg, @PathVariable("id") Long id) {
//        System.out.println(inputImg.getOriginalFilename());
//        System.out.println(id);
//    }


    @GetMapping("/admin/customer/view")
    public List<GetUserDTO> viewCustomer() {
        List<Customer> customerList = customerService.findAllUser();
        return customerList.stream().map(UserInfoMapper.INSTANCE::userToGetUserDTO ).collect(Collectors.toList());
    }

    @GetMapping("/admin/customer/detail/{id}")
    public GetUserDTO viewDetailCustomer(@PathVariable("id") Long id) {
        GetUserDTO temp = UserInfoMapper.INSTANCE.userToGetUserDTO(customerService.findUserById(id));
        return temp;
    }

    @DeleteMapping("/admin/customer/delete/{id}")
    public void  deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/admin/staff/view")
    public List<Staff> viewStaff() {
        return staffService.findAll();
    }

    @GetMapping("/admin/staff/detail/{id}")
    public Staff viewDetailStaff(@PathVariable("id") Long id) {
        return staffService.findById(id);
    }

    @PostMapping("/admin/staff/modify")
    public void modifyStaff(@RequestBody Staff staff) throws IOException {
        staffService.save(staff);
    }

    @PostMapping("/admin/staff/create")
    public boolean createStaff(@RequestBody Staff staff) throws IOException {
        if( staffService.checkUsernameExists(staff.getUsername()) )
        {
            return false;
        }
        else {
            staffService.save(staff);
            return true;
        }
    }

    @DeleteMapping("/admin/staff/delete/{id}")
    public void deleteStaff(@PathVariable("id") Long id) {
        staffService.deleteById(id);
    }

}


