package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.Image;
import com.ptit.ttcs.bookstore.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImg(Image image) {
        return imageRepository.save(image);
    }
}
