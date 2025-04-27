package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Book;
import com.ptit.ttcs.bookstore.domain.Compose;
import com.ptit.ttcs.bookstore.repository.BookRepository;
import com.ptit.ttcs.bookstore.repository.ComposeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ComposeRepository composeRepository;
    public BookService(BookRepository bookRepository, ComposeRepository composeRepository) {
        this.bookRepository = bookRepository;
        this.composeRepository = composeRepository;
    }


    public List<Book> findAllBook() {
        return this.bookRepository.findAll();
    }



}
