package com.ptit.ttcs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String email;
    String username;
    String password;
    String fullname;
    Integer age;
    String gender;
    String phone;
    String address;

    @OneToOne()
    @JoinColumn(name="avaImg_id", referencedColumnName = "id")
    private Image image;

//    @OneToOne()
//    @JoinColumn(name="cart_id",referencedColumnName = "id" )
//    private Cart cart;

    @OneToMany(mappedBy = "user")
    List<Receipt> receipt_list;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Receipt> getReceipt_list() {
        return receipt_list;
    }

    public void setReceipt_list(List<Receipt> receipt_list) {
        this.receipt_list = receipt_list;
    }

//    public Cart getCart() {
//        return cart;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFullname(String fname) {
        this.fullname = fname;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
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

    public void UserAdded() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", image=" + image +
                ", receipt_list=" + receipt_list +
                '}';
    }
}


