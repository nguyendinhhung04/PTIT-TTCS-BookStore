package com.ptit.ttcs.bookstore.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    String id;
    String type;

    @Lob  // Large Object - (pdf, image,....)
    @Column(columnDefinition = "LONGBLOB")  // data type for mySQL
    private byte[] data;

    @OneToOne(mappedBy = "image")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
