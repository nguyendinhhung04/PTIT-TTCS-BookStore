package com.ptit.ttcs.bookstore.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    Long id;
    Integer quantity;
    float price;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    Invoice invoice;

    @ManyToOne
    @JoinColumn(name="book_id")
    Book book;
}
