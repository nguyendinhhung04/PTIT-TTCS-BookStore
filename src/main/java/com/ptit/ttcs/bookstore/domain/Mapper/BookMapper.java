package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.DTO.Book.BookDTO;
import com.ptit.ttcs.bookstore.service.PublisherService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);


    default public Book toBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }

        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setBook_name(bookDTO.getBook_name());
        book.setPrice(bookDTO.getPrice());
        book.setAge_limit(bookDTO.getAge_limit());
        book.setDiscount(bookDTO.getDiscount());
        book.setIntroduction(bookDTO.getIntroduction());
        book.setPublish_date(bookDTO.getPublish_date());
        book.setTranslator(bookDTO.getTranslator());
        book.setCategory(bookDTO.getCategory());
        book.setLanguage(bookDTO.getLanguage());
        book.setPublisher(null);
        book.setCoverImage(bookDTO.getCoverImage());
        book.setComposes(null);
        book.setCode(bookDTO.getCode());
        book.setQuantity( bookDTO.getQuantity());
        book.setOnSale( bookDTO.isOnSale() );
        return book;
    }

    default public BookDTO toBookDTO(Book book) {
        if (book == null) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setBook_name(book.getBook_name());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setAge_limit(book.getAge_limit());
        bookDTO.setDiscount(book.getDiscount());
        bookDTO.setIntroduction(book.getIntroduction());
        bookDTO.setPublish_date(book.getPublish_date());
        bookDTO.setTranslator(book.getTranslator());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setPublisher_id(book.getPublisher().getId());
        bookDTO.setCoverImage(book.getCoverImage());
        bookDTO.setAuthor_ids(book.getComposes().stream().map(compose -> compose.getAuthor().getId()).toList());
        bookDTO.setCode(book.getCode());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setOnSale(book.isOnSale());
        return bookDTO;
    }
}
