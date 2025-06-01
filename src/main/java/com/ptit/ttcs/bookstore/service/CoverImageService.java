package com.ptit.ttcs.bookstore.service;

import com.ptit.ttcs.bookstore.domain.CoverImage;
import com.ptit.ttcs.bookstore.repository.CoverImageRepository;
import org.springframework.stereotype.Service;

@Service
public class CoverImageService {

    private final CoverImageRepository coverImageRepository;

    public CoverImageService( CoverImageRepository coverImageRepository ) {
        this.coverImageRepository = coverImageRepository;
    }

    public CoverImage saveCoverImage(CoverImage coverImage) {
        return coverImageRepository.save(coverImage);
    }

}
