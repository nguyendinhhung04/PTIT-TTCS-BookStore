package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.Author;
import com.ptit.ttcs.bookstore.domain.DTO.AuthorDTO;

public class AuthorMapper {
    public static AuthorDTO toDTO(Author author, String imageUrl) {
        if (author == null) return null;

        return new AuthorDTO(
            author.getId(),
            author.getName(),
            author.getAge(),
            author.getIntroduction(),
            imageUrl // truyền đường dẫn ảnh hoặc null nếu chưa có
        );
    }
}
