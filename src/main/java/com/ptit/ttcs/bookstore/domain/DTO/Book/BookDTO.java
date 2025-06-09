package com.ptit.ttcs.bookstore.domain.DTO.Book;

import com.ptit.ttcs.bookstore.domain.*;
import com.ptit.ttcs.bookstore.domain.enums.Category;
import com.ptit.ttcs.bookstore.domain.enums.Language;
import jakarta.persistence.*;

import java.util.List;

public class BookDTO {
    Long id;

    String book_name;

    float price;

    Integer age_limit;

    float discount;

    String introduction;

    String publish_date;

    String translator;

    List<Long> author_ids;

    com.ptit.ttcs.bookstore.domain.enums.Category category;

    com.ptit.ttcs.bookstore.domain.enums.Language language;

    Long publisher_id;

    CoverImage coverImage;

    String code;

    int quantity;
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(Integer age_limit) {
        this.age_limit = age_limit;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public List<Long> getAuthor_ids() {
        return author_ids;
    }

    public void setAuthor_ids(List<Long> author_ids) {
        this.author_ids = author_ids;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", price=" + price +
                ", age_limit=" + age_limit +
                ", discount=" + discount +
                ", introduction='" + introduction + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", translator='" + translator + '\'' +
                ", author_ids=" + author_ids +
                ", category=" + category +
                ", language=" + language +
                ", publisher_id=" + publisher_id +
                ", coverImage=" + coverImage +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
