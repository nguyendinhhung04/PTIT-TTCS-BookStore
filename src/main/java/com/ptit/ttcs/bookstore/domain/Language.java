package com.ptit.ttcs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="language")
public class Language {

    @Id
    @JsonView(View.Basic.class)
    Long id;
    @JsonView(View.Basic.class)
    String name;

    @JsonView(View.AllBookInLanguage.class)
    @OneToMany(mappedBy = "language")
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

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
