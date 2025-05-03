package com.ptit.ttcs.bookstore.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.repository.ComposeRepository;
import com.ptit.ttcs.bookstore.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class BookControler {
    private final BookService bookService;
    private final ComposeRepository composeRepository;

    BookControler(
            BookService bookService,
            ComposeRepository composeRepository) {
        this.bookService = bookService;
        this.composeRepository = composeRepository;
    }

    @GetMapping("/admin/resource/book/view")
    public List<Book> viewBook() {
        System.out.println("Access form frontend");
        return this.bookService.findAllBook();
    }
}
