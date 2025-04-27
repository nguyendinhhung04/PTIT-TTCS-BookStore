package com.ptit.ttcs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="publisher")
public class Publisher {

    @Id
    @JsonView(View.Basic.class)
    Long id;
    @JsonView(View.Basic.class)
    String name;
    @JsonView(View.Basic.class)
    String img;

    @JsonView(View.AllBookOfPublisher.class)
    @OneToMany(mappedBy = "publisher")
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                '}';
    }   
}
