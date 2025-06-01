package com.ptit.ttcs.bookstore.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.CoverImage;
import com.ptit.ttcs.bookstore.domain.DTO.Book.BookDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.BookMapper;
import com.ptit.ttcs.bookstore.repository.ComposeRepository;
import com.ptit.ttcs.bookstore.repository.CoverImageRepository;
import com.ptit.ttcs.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class BookControler {
    private final BookService bookService;
    private final ComposeRepository composeRepository;
    private final CoverImageRepository coverImageRepository;

    BookControler(
            BookService bookService,
            ComposeRepository composeRepository, CoverImageRepository coverImageRepository) {
        this.bookService = bookService;
        this.composeRepository = composeRepository;
        this.coverImageRepository = coverImageRepository;
    }

    @GetMapping("/admin/resource/book/all")
    public List<BookDTO> viewBook() {
        System.out.println("Access form frontend");
        List<BookDTO> bookDTOs = bookService.findAllBook().stream()
                .map(BookMapper.INSTANCE::toBookDTO)
                .toList();
        return bookDTOs;
    }

    @PostMapping("/admin/resource/book/create")
    public void createBook(@RequestPart("bookInfo") BookDTO bookDTO, @RequestPart("inputImg") MultipartFile inputImg) throws IOException {

        Book newBook = bookService.save(BookMapper.INSTANCE.toBook(bookDTO));

        String fileName = inputImg.getOriginalFilename();
        String fileType = inputImg.getContentType();
        byte[] data = inputImg.getBytes();

        CoverImage coverImg = new CoverImage();
        coverImg.setData(data);
        coverImg.setType(fileType);

        CoverImage new_image = coverImageRepository.save(coverImg);
        newBook.setCoverImage(new_image);
        bookService.save(newBook);
    }

    @GetMapping("/admin/resource/book/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if (book != null) {
            return BookMapper.INSTANCE.toBookDTO(book);
        } else {
            return null; // Hoặc ném một exception nếu không tìm thấy sách
        }
    }

    @DeleteMapping("/admin/resource/book/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
