package com.ptit.ttcs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="bill")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String create_date;
    String payment_date;

    @ManyToOne
    @JoinColumn(name="customer_id")
    Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Customer getUser() {
        return customer;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

//    public List<BillDetail> getBillDetails() {
//        return billDetails;
//    }
//
//    public void setBillDetails(List<BillDetail> billDetails) {
//        this.billDetails = billDetails;
//    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", create_date='" + create_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", customer=" + customer +
//                ", billDetails=" + billDetails +
                '}';
    }
}
