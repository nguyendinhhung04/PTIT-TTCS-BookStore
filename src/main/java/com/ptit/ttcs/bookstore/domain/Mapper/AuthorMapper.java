package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.Author;
import com.ptit.ttcs.bookstore.domain.DTO.Author.AuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    default Author toAuthor(AuthorDTO authorDTO) {
        if (authorDTO == null) {
            return null;
        }

        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setAge(authorDTO.getAge());
        author.setIntroduction(authorDTO.getIntroduction());
        author.setComposes(authorDTO.getComposes());
        return author;
    }

    default AuthorDTO toDTO(Author author) {
        if (author == null) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setAge(author.getAge());
        authorDTO.setIntroduction(author.getIntroduction());
        authorDTO.setComposes(author.getComposes());
        return authorDTO;
    }
}
