package com.ptit.ttcs.bookstore.controller;

import com.ptit.ttcs.bookstore.domain.Category;
import com.ptit.ttcs.bookstore.domain.DTO.Category.CategoryDTO;
import com.ptit.ttcs.bookstore.domain.Mapper.CategoryMapper;
import com.ptit.ttcs.bookstore.domain.Mapper.PublisherMapper;
import com.ptit.ttcs.bookstore.repository.CategoryRepository;
import com.ptit.ttcs.bookstore.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Cho phép React gọi API

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/resource/category/all")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAll().stream()
                .map(CategoryMapper.INSTANCE::toDTO)
                .toList();
    }

    @GetMapping("/admin/resource/category/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return CategoryMapper.INSTANCE.toDTO(category);
    }

    @PostMapping("/admin/resource/category/create")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryDTO);
        Category savedCategory = categoryService.save(category);
        return CategoryMapper.INSTANCE.toDTO(savedCategory);
    }

    @DeleteMapping("/admin/resource/category/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

}
