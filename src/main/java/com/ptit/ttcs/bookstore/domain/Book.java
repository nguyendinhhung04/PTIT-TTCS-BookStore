package com.ptit.ttcs.bookstore.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="book")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String book_name;

    float price;

    Integer age_limit;

    float discount;

    @Column(columnDefinition = "TEXT")
    String introduction;

    String publish_date;

    String translator;

    String cover_img;

    @OneToMany(mappedBy = "book")
    List<Compose> composes;

    @OneToMany(mappedBy ="book" )
    List<BookInCart> bookInCarts;

    @OneToMany(mappedBy = "book")
    List<ReceiptDetail> receiptDetails;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "language_id")
    Language language;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;

    public List<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(List<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    public List<BookInCart> getBookInCarts() {
        return bookInCarts;
    }

    public void setBookInCarts(List<BookInCart> bookInCarts) {
        this.bookInCarts = bookInCarts;
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

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public List<Compose> getComposes() {
        return composes;
    }

    public void setComposes(List<Compose> composes) {
        this.composes = composes;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", price=" + price +
                ", age_limit=" + age_limit +
                ", discount=" + discount +
                ", introduction='" + introduction + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", translator='" + translator + '\'' +
                ", cover_img='" + cover_img + '\'' +
                ", composes=" + composes +
                ", bookInCarts=" + bookInCarts +
                ", receiptDetails=" + receiptDetails +
                ", category=" + category +
                ", language=" + language +
                ", publisher=" + publisher +
                '}';
    }
}
