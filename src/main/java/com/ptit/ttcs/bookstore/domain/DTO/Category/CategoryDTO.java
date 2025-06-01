package com.ptit.ttcs.bookstore.domain.DTO.Category;

import com.ptit.ttcs.bookstore.domain.Book;
import jakarta.persistence.OneToMany;

import java.util.List;

public class CategoryDTO {

    Long id;
    String name;
    List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
