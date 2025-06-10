package com.ptit.ttcs.bookstore.domain.DTO.BillDTO;

import com.ptit.ttcs.bookstore.domain.Customer;
import com.ptit.ttcs.bookstore.domain.DTO.GetUserDTO;

import java.util.List;

public class billFeDTO {

    Long id;
    String create_date;
    String payment_date;
    GetUserDTO customer;
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

    public GetUserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(GetUserDTO customer) {
        this.customer = customer;
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
                ", customer=" + customer +
                ", billDetailsFe=" + billDetailsFe +
                '}';
    }
}
