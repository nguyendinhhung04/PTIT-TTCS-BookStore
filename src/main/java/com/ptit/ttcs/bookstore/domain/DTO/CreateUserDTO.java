package com.ptit.ttcs.bookstore.domain.DTO;

public class CreateUserDTO {
    String fullname;
    Integer age;
    String gender;
    String address;
    String email;
    String password;
    String phone;
    String username;
    String ava_img;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAva_img() {
        return ava_img;
    }

    public void setAva_img(String ava_img) {
        this.ava_img = ava_img;
    }

    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CreateUserDTO{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", ava_img='" + ava_img + '\'' +
                '}';
    }
}
