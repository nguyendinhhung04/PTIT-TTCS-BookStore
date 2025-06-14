package com.ptit.ttcs.bookstore.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.ptit.ttcs.bookstore.JsonViews.View;
import com.ptit.ttcs.bookstore.domain.*;
import com.ptit.ttcs.bookstore.domain.DTO.Book.BookDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.BookMapper;
import com.ptit.ttcs.bookstore.repository.ComposeRepository;
import com.ptit.ttcs.bookstore.repository.CoverImageRepository;
import com.ptit.ttcs.bookstore.service.AuthorService;
import com.ptit.ttcs.bookstore.service.BookService;
import com.ptit.ttcs.bookstore.service.PublisherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class BookControler {
    private final BookService bookService;
    private final CoverImageRepository coverImageRepository;
    private final PublisherService publisherService;
    private final ComposeRepository composeRepository;
    private final AuthorService authorService;

    BookControler(
            BookService bookService,
            ComposeRepository composeRepository, CoverImageRepository coverImageRepository,
            PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.coverImageRepository = coverImageRepository;
        this.publisherService = publisherService;
        this.composeRepository = composeRepository;
        this.authorService = authorService;
    }

    @GetMapping("/admin/resource/book/all")
    public List<BookDTO> viewBook() {
        List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
        List<Book> books = bookService.findAllBook();
        for( Book book : books) {
            bookDTOs.add( BookMapper.INSTANCE.toBookDTO(book));
        }
        return bookDTOs;
    }

    @GetMapping("/admin/resource/book/onSale")
    public List<BookDTO> viewOnSaleBook() {
        List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
        List<Book> books = bookService.findBookOnSale();
        for( Book book : books) {
            bookDTOs.add( BookMapper.INSTANCE.toBookDTO(book));
        }
        return bookDTOs;
    }

    @GetMapping("/admin/resource/book/code/{code}")
    public BookDTO getBookByCode(@PathVariable String code) {
        Book book = bookService.findBookByCode(code);
        if (book != null) {
            return BookMapper.INSTANCE.toBookDTO(book);
        } else {
            return null; // Hoặc ném một exception nếu không tìm thấy sách
        }
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

        Publisher publisher = publisherService.getPublisherById(bookDTO.getPublisher_id());
        newBook.setPublisher(publisher);

        List<Compose> composes = new ArrayList<>();
        for (Long authorId : bookDTO.getAuthor_ids()) {
            composes.add(authorService.addCompose( newBook.getId(), authorId ));
        }
        newBook.setComposes(composes);

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
        Book book = bookService.findBookById(id);
        if (book == null) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        coverImageRepository.deleteById(book.getCoverImage().getId());
        bookService.deleteBook(id);
    }

//    @PutMapping("/admin/resource/book/update/")
//    public void updateBookInfo( @RequestPart("bookInfo") BookDTO bookDTO, @RequestPart("inputImg") MultipartFile inputImg) throws IOException {
//        Book book = BookMapper.INSTANCE.toBook(bookDTO);
////        bookService.save(book);
//        System.out.println(book);
//        System.out.println(inputImg);
//    }

    @PostMapping("/admin/resource/book/updateInfo")
    public void updateBookInfo(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toBook(bookDTO);

        List<Compose> composes = new ArrayList<Compose>();
        for (Long authorId : bookDTO.getAuthor_ids()) {
            composes.add(authorService.getComposesById(authorId));
        }
        book.setComposes(composes);
        Publisher publisher = publisherService.getPublisherById(bookDTO.getPublisher_id());
        book.setPublisher(publisher);
        bookService.save(book);
    }

    @PostMapping("/admin/resource/book/uploadImg/{id}")
    public void uploadImg(@PathVariable Long id, @RequestPart MultipartFile inputImg) throws IOException
    {
        String fileName = inputImg.getOriginalFilename();
        String fileType = inputImg.getContentType();
        byte[] data = inputImg.getBytes();

        CoverImage coverImg = new CoverImage();
        coverImg.setData(data);
        coverImg.setType(fileType);
        coverImg.setId(id);

        CoverImage new_image = coverImageRepository.save(coverImg);
    }


}
