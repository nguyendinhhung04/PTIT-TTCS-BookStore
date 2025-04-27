package com.ptit.ttcs.bookstore.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
//    @JsonView(View.Basic.class)
    Long id;

    @JsonView(View.Basic.class)
    String name;

    @JsonView(View.Basic.class)
    Integer age;

    @JsonView(View.Basic.class)
    @Column(columnDefinition = "TEXT")
    String introduction;


    @JsonView(View.AuthorWithBook.class)
    @OneToMany(mappedBy = "author")
    List<Compose> composes;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
