package com.ptit.ttcs.bookstore.domain.DTO.Publisher;

import com.ptit.ttcs.bookstore.domain.Book;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PublisherDTO {

    Long id;
    String name;
//    List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    @Override
    public String toString() {
        return "PublisherDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
