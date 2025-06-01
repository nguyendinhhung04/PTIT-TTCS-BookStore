package com.ptit.ttcs.bookstore.domain;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "cover_img")
public class CoverImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String type;

    @Lob  // Large Object - (pdf, image,....)
    @Column(columnDefinition = "LONGBLOB")  // data type for mySQL
    private byte[] data;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "CoverImage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
