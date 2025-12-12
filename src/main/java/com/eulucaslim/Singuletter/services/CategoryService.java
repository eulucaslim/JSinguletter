package com.eulucaslim.Singuletter.services;


import com.eulucaslim.Singuletter.entity.Category;
import com.eulucaslim.Singuletter.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        List<Category> categories = repository.findAll();
        return categories;
    }

    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);
        return category.get();
    }
}
