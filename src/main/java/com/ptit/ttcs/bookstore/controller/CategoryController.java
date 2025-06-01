package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.enums.Category;
import com.ptit.ttcs.bookstore.domain.enums.Language;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API

public class CategoryController {


    @GetMapping("/admin/resource/category/all")
    public List<String> getAllCategories() {
        return Arrays.stream(Category.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @GetMapping("/admin/resource/language/all")
    public List<String> getAllLanguagues() {
        return Arrays.stream(Language.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
