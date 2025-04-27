package com.ptit.ttcs.bookstore.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @JsonView(View.Basic.class)
    Long id;

    @JsonView(View.Basic.class)
    String book_name;

    @JsonView(View.Basic.class)
    float price;

    @JsonView(View.Basic.class)
    Integer age_limit;

    @JsonView(View.Basic.class)
    float discount;

    @JsonView(View.Basic.class)
    @Column(columnDefinition = "TEXT")
    String introduction;

    @JsonView(View.Basic.class)
    String publish_date;

    @JsonView(View.Basic.class)
    String translator;

    @JsonView(View.Basic.class)
    String cover_img;

    @JsonView(View.BookInfo.class)
    @OneToMany(mappedBy = "book")
    List<Compose> composes;

    @OneToMany(mappedBy ="book" )
    List<BookInCart> bookInCarts;

    @OneToMany(mappedBy = "book")
    List<InvoiceDetail> invoiceDetails;

    @JsonView(View.BookInfo.class)
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @JsonView(View.BookInfo.class)
    @ManyToOne
    @JoinColumn(name = "language_id")
    Language language;

    @JsonView(View.BookInfo.class)
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;

    public List<BookInCart> getBookInCarts() {
        return bookInCarts;
    }

    public void setBookInCarts(List<BookInCart> bookInCarts) {
        this.bookInCarts = bookInCarts;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
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
                ", invoiceDetails=" + invoiceDetails +
                ", category=" + category +
                ", language=" + language +
                ", publisher=" + publisher +
                '}';
    }
}
