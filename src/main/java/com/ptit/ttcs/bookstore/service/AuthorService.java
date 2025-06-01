package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Author;
import com.ptit.ttcs.bookstore.domain.Compose;
import com.ptit.ttcs.bookstore.repository.AuthorRepository;
import com.ptit.ttcs.bookstore.repository.ComposeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final ComposeRepository composeRepository;
    private final BookService bookService;

    public AuthorService(AuthorRepository authorRepository
    , ComposeRepository composeRepository,
                         BookService bookService) {
        this.authorRepository = authorRepository;
        this.composeRepository = composeRepository;
        this.bookService = bookService;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }

    public Compose getComposesById(Long id) {
        return composeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compose not found with id: " + id));
    }

    public Compose addCompose(Long bookId, Long authorId) {
        Compose newCompose = new Compose();
        newCompose.setAuthor( this.getAuthorById(authorId) );
        newCompose.setBook( bookService.findBookById(bookId) );
        return composeRepository.save(newCompose);
    }

}
