package com.ptit.ttcs.bookstore.domain.DTO.BillDTO;

public class BillDetailDTO {
    Long book_id;
    Float price;
    Integer quantity;


    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        book_id = book_id;
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
                "Book_id=" + book_id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
