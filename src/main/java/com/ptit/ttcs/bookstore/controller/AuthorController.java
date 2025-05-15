package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.Author;
import com.ptit.ttcs.bookstore.domain.DTO.AuthorDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.AuthorMapper;
import com.ptit.ttcs.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin("*")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();

        return authorRepository.findAll().stream()
        .map(author -> AuthorMapper.toDTO(author, null))
        .collect(Collectors.toList());
    
    }
}
