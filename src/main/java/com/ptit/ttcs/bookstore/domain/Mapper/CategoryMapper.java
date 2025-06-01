package com.ptit.ttcs.bookstore.domain.Mapper;

import com.ptit.ttcs.bookstore.domain.Category;
import com.ptit.ttcs.bookstore.domain.DTO.Category.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    default Category toCategory(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setBooks(categoryDTO.getBooks());
        return category;
    }

    default CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setBooks(category.getBooks());
        return categoryDTO;
    }
}
