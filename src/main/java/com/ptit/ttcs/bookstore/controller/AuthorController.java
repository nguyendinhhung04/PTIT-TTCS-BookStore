package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.Author;
import com.ptit.ttcs.bookstore.domain.Compose;
import com.ptit.ttcs.bookstore.domain.DTO.Author.AuthorDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.AuthorMapper;
import com.ptit.ttcs.bookstore.domain.Mapper.BookMapper;
import com.ptit.ttcs.bookstore.repository.AuthorRepository;
import com.ptit.ttcs.bookstore.repository.ComposeRepository;
import com.ptit.ttcs.bookstore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class AuthorController {


    private final AuthorRepository authorRepository;
    private final AuthorService authorService;
    private final ComposeRepository composeRepository;

    public AuthorController(AuthorRepository authorRepository, AuthorService authorService, ComposeRepository composeRepository) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.composeRepository = composeRepository;
    }

    @GetMapping("/admin/resource/author/all")
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorService.getAllAuthors().stream()
                .map(AuthorMapper.INSTANCE::toDTO)
                .toList();
    }

    @GetMapping("/admin/resource/author/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        return AuthorMapper.INSTANCE.toDTO(author);
    }

    @PostMapping("/admin/resource/author/create")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = AuthorMapper.INSTANCE.toAuthor(authorDTO);
        Author savedAuthor = authorService.saveAuthor(author);
        return AuthorMapper.INSTANCE.toDTO(savedAuthor);
    }

    @GetMapping("/admin/resource/compose/{id}")
    public Compose getComposesById(@PathVariable Long id) {
//        Long idLong = Long.parseLong(id);
//        System.out.println(idLong);
//        System.out.println(id);
        return composeRepository.findById(id).orElse(null);
    }
}
