package com.eulucaslim.Singuletter.controllers;


import com.eulucaslim.Singuletter.entity.Category;
import com.eulucaslim.Singuletter.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(categories);
    }
// FIXME: Create controller to find Category by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> findCategoryById(PathVariable id) {
//        Category category = categoryService.
//    }
}
