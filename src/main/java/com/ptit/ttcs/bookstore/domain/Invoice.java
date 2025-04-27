package com.ptit.ttcs.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    Long id;
    String create_date;
    String payment_date;

    @OneToMany(mappedBy = "invoice")
    List<UserInvoice> userInvoices;

    @OneToMany(mappedBy = "invoice")
    List<InvoiceDetail> invoiceDetails;

}
