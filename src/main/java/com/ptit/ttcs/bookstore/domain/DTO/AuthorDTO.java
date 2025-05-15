package com.ptit.ttcs.bookstore.domain.DTO;

public class AuthorDTO {
    private Long id;
    private String name;
    private Integer age;
    private String introduction;
    private String imageUrl; // URL ảnh đại diện tác giả (nếu cần)

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String name, Integer age, String introduction, String imageUrl) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.introduction = introduction;
        this.imageUrl = imageUrl;
    }

    // Getters và setters
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
