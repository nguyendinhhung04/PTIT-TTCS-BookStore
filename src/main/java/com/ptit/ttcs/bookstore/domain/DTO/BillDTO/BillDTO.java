package com.ptit.ttcs.bookstore.domain.DTO.BillDTO;

import com.ptit.ttcs.bookstore.domain.Customer;

import java.util.List;

public class BillDTO {

    Long id;
    String create_date;
    String payment_date;
    Long customer_id;
    List<Long> book_ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }


    public List<Long> getBook_ids() {
        return book_ids;
    }

    public void setBook_ids(List<Long> book_ids) {
        this.book_ids = book_ids;
    }

    @Override
    public String toString() {
        return "BillDTO{" +
                "id=" + id +
                ", create_date='" + create_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", customer_id=" + customer_id +
                ", book_ids=" + book_ids +
                '}';
    }
}
