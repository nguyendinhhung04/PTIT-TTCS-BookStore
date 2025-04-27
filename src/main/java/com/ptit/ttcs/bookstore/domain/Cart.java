package com.ptit.ttcs.bookstore.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Cart")
public class Cart {

    @Id
    Long id;

    @OneToOne(mappedBy = "cart")
    private User user;

    @OneToMany(mappedBy = "cart")
    List<BookInCart> bookInCarts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookInCart> getBookInCarts() {
        return bookInCarts;
    }

    public void setBookInCarts(List<BookInCart> bookInCarts) {
        this.bookInCarts = bookInCarts;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", bookInCarts=" + bookInCarts +
                '}';
    }
}
