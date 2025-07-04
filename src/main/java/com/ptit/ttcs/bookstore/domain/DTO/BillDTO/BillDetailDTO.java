package com.ptit.ttcs.bookstore.domain.DTO.BillDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillDetailDTO {

    Long bookId;
    Float price;
    Integer quantity;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillDetailDTO{" +
                "bookId=" + bookId +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
