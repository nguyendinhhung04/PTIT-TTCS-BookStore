package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.DTO.Publisher.PublisherDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.AuthorMapper;
import com.ptit.ttcs.bookstore.domain.Mapper.PublisherMapper;
import com.ptit.ttcs.bookstore.domain.Publisher;
import com.ptit.ttcs.bookstore.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return ResponseEntity.ok(publisherService.createPublisher(publisher));
    }

    @GetMapping("/admin/resource/publisher/all")
    public List<PublisherDTO> getAllPublishers() {
        return publisherService.getAllPublishers().stream()
                .map(PublisherMapper.INSTANCE::toDTO)
                .toList();
    }

    @GetMapping("/admin/resource/publisher/{id}")
    public PublisherDTO getPublisherById(@PathVariable Long id) {
        return PublisherMapper.INSTANCE.toDTO(publisherService.getPublisherById(id));
    }

    @DeleteMapping("/admin/resource/publisher/delete/{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
    }
}
