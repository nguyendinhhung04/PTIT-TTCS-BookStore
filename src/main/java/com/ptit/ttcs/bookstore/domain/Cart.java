//package com.ptit.ttcs.bookstore.domain;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Entity
//@Table(name="Cart")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//public class Cart implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//
//    @OneToOne(mappedBy = "cart")
//    private User user;
//
//    @OneToMany(mappedBy = "cart")
//    List<BookInCart> bookInCarts;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<BookInCart> getBookInCarts() {
//        return bookInCarts;
//    }
//
//    public void setBookInCarts(List<BookInCart> bookInCarts) {
//        this.bookInCarts = bookInCarts;
//    }
//
//    @Override
//    public String toString() {
//        return "Cart{" +
//                "id=" + id +
//                ", user=" + user +
//                ", bookInCarts=" + bookInCarts +
//                '}';
//    }
//}
