package com.ptit.ttcs.bookstore.domain.DTO.BillDTO;

import java.util.List;

public class billFeDTO {

    Long id;
    String create_date;
    String payment_date;
    String customer_name;
    List<billDetailFeDTO> billDetailsFe ;

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

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public List<billDetailFeDTO> getBillDetailsFe() {
        return billDetailsFe;
    }

    public void setBillDetailsFe(List<billDetailFeDTO> billDetailsFe) {
        this.billDetailsFe = billDetailsFe;
    }

    @Override
    public String toString() {
        return "billFeDTO{" +
                "id=" + id +
                ", create_date='" + create_date + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", customer_name=" + customer_name +
                ", billDetailsFe=" + billDetailsFe +
                '}';
    }
}
