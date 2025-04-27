package com.ptit.ttcs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import jakarta.persistence.*;

@Entity
@Table(name="compose")
public class Compose {

    @Id
    @JsonView(View.Basic.class)
    Long id;

    @JsonView(View.AuthorWithBook.class)
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @JsonView(View.BookInfo.class)
    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Compose{" +
                "id=" + id +
                ", book=" + book +
                ", author=" + author +
                '}';
    }
}
