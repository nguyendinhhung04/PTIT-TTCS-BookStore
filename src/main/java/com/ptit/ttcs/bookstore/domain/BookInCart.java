package com.ptit.ttcs.bookstore.domain;

import jakarta.persistence.*;

@Entity
@Table(name="book_in_cart")
public class BookInCart {

    @Id
    Long id;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name="cart_id", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookInCart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", cart=" + cart +
                ", book=" + book +
                '}';
    }
}
