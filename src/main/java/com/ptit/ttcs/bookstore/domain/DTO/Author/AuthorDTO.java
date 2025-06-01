package com.ptit.ttcs.bookstore.domain.DTO.Author;

import com.ptit.ttcs.bookstore.domain.Compose;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public class AuthorDTO {

    Long id;

    String name;

    Integer age;

    String introduction;

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

    public List<Compose> getComposes() {
        return composes;
    }

    public void setComposes(List<Compose> composes) {
        this.composes = composes;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", introduction='" + introduction + '\'' +
                ", composes=" + composes +
                '}';
    }
}
