package com.ptit.ttcs.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="receipt")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Receipt implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String create_date;
    String payment_date;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @OneToMany(mappedBy = "receipt")
    List<ReceiptDetail> receiptDetails;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(List<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", create_date='" + create_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", user=" + user +
                ", receiptDetails=" + receiptDetails +
                '}';
    }
}
