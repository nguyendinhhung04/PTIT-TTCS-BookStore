package com.ptit.ttcs.bookstore.domain.DTO.Book;

import com.ptit.ttcs.bookstore.domain.*;
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

    List<Compose> composes;

    List<ReceiptDetail> receiptDetails;

    Category category;

    Language language;

    Publisher publisher;

    CoverImage coverImage;

    String code;

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

    public List<Compose> getComposes() {
        return composes;
    }

    public void setComposes(List<Compose> composes) {
        this.composes = composes;
    }

    public List<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(List<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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
                " code='" + code + '\'' +
                ", price=" + price +
                ", age_limit=" + age_limit +
                ", discount=" + discount +
                ", introduction='" + introduction + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", translator='" + translator + '\'' +
                ", composes=" + composes +
                ", receiptDetails=" + receiptDetails +
                ", category=" + category +
                ", language=" + language +
                ", publisher=" + publisher +
                ", coverImage=" + coverImage +
                '}';
    }
}
